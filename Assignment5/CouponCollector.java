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

public class CouponCollector {
    public int[] coupons;
	
  public int init(int n) {
	  //initial the coupon array
	  coupons = new int[n];
	  for (int i = 0; i<n; i++) coupons[i]=0;
	  int m = 0;
	  while (!check(coupons,n)) { 
		  m++;
		  coupons[newCoupon(n)]++;
	  }
	  //for (int i = 0; i<n; i++) System.out.print(coupons[i]+" ");
	  //System.out.println();
	return m-1;
	  
  }
  
  public int newCoupon(int n){
	  
	  Random ran = new Random();
	  int x = ran.nextInt(20000);
	  //System.out.println(x);
	  return hash(n,x); 
	  
  }
  
  public boolean check(int[] coupons, int n) {
	  //for (int i = 0;i<n;i++) System.out.print(coupons[i]+" ");
	  //System.out.println();
	  for (int i = 0;i<n;i++) 
		  if (coupons[i]==0) return false;
	 // for (int i = 0;i<n;i++) System.out.print(coupons[i]+" ");
	return true;
	
  }
  
  public int hash(int n,int x) {
	  
	  int hash = x % n;
	  
	return hash;  
  }
  
  public static void main (String[] args) {
	  CouponCollector cp = new CouponCollector();
	  
	  Random ran = new Random();
	  System.out.println("m       n            mlnm      Error");
	  for (int i=1; i<=20;i++) {
		  int n = ran.nextInt(1000)+1;  
		  double s= 0;
		  for (int j = 1;j<=1000;j++) 
		  s+=cp.init(n);
		  s/=1000;
		  double TheAns = n*Math.log(n);
		  DecimalFormat df = new DecimalFormat("0.00");
		  System.out.println(n+"     "+s+"     "+df.format(TheAns)+"     "+df.format((s-TheAns)/TheAns*100)+"%");
	  }
  }
  
}
