/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.yitingassignment1;

/**
 *
 * @author yitinwang
 */
import java.util.Random;

public class randomWalk {
    private int x;
    private int y;

    //private final Random random = new Random();
    public void setOrigin(){
        x = 0;
        y = 0;
    }
    
    public void move(int dx, int dy) {
        // TODO you need to implement this
    	    x+=dx;
    	    y+=dy;
    	    
    	    //System.out.println("dx:"+dx+" dy"+dy+" x:"+x+" y:"+y);
    }

     double randomWalk(int n) {
    	x = 0;
        y = 0;
        for (int i = 0; i < n; i++) 
    	   randomMove();
        return distance(); 
    }

    private void randomMove() {
        // TODO you need to implement this
      	Random ran = new Random();
		int dir = ran.nextInt(4);
		
		//System.out.println(dir);
		
		switch (dir)
		{
		case 0:
			move(1,0);
			break;
		case 1:
			move(0,-1);
			break;
		case 2:
			move(-1,0);
			break;
		case 3:
			move(0,1);
			break;
		}
    }

    public double distance() {
    	double d;
	return d = Math.sqrt(x*x+y*y);// TODO you need to implement this
    }
    
}
