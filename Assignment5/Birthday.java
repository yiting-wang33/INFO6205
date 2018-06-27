/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.info6205assignmentbirthday;

/**
 *
 * @author yitinwang
 */
import java.text.DecimalFormat;
import java.util.Random;
public class Birthday {
    public int[] days;
	
	public int init(int m) {
		days = new int[m];
		for (int i = 0; i<days.length;i++) days[i] = 0;
		//for (int j = 0; j<days.length;j++) System.out.print(days[j]);
		int n = 0;
		while (!check()) {
			n++;
			days[newDay(m)]++;
		}
		//System.out.println(m-1);
		return n-1;
	}
	
	public boolean check() {
		for (int i = 0; i<days.length;i++) {
			if (days[i]>1) {
				//for (int j = 0; j<days.length;j++) System.out.print(days[j]);
				return true;
			}
		}
		return false;
	}
	
	public int newDay(int m) {
		Random ran = new Random();
		int x = ran.nextInt(10000);
		return hash(m,x);
	}
	
	public int hash(int m,int x) {
		//System.out.println(x%n);
		return (x % m);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Birthday bd = new Birthday();
        double s = 0;
        System.out.println(" m        n       sqrt(πm/2)     Error");
        for (int i=1; i<=20;i++) {
        		Random ran = new Random();
        		int m = ran.nextInt(400);
        		for (int j = 0; j<=1000; j++) {
        			s+=bd.init(m);
        		}
        		s/=1000;
        		DecimalFormat df = new DecimalFormat("0.00");
        		double TheVal = Math.sqrt(Math.PI*m/2);
        		System.out.println(m+"      "+df.format(s)+"     "+df.format(TheVal)+"     "+df.format(Math.abs((s-TheVal)/TheVal*100))+"%");
        }
	}

}
