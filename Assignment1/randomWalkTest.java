/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.yitingassignment1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yitinwang
 */
public class randomWalkTest {
    
     /**
     */
    @Test
    public void testMove1() {
        randomWalk rw = new randomWalk();
        rw.move(1, 0);
        assertEquals(rw.distance(), 1.0, 1.0E-7);
        rw.move(1, 0);
        assertEquals(rw.distance(), 2.0, 1.0E-7);
        rw.move(-1, 0);
        assertEquals(rw.distance(), 1.0, 1.0E-7);
        rw.move(-1, 0);
        assertEquals(rw.distance(), 0.0, 1.0E-7);
    }

    /**
     */
    @Test
    public void testMove2() {
        randomWalk rw = new randomWalk();
        rw.move(0, 1);
        assertEquals(rw.distance(), 1.0, 1.0E-7);
        rw.move(0, 1);
        assertEquals(rw.distance(), 2.0, 1.0E-7);
        rw.move(0, -1);
        assertEquals(rw.distance(), 1.0, 1.0E-7);
        rw.move(0, -1);
        assertEquals(rw.distance(), 0.0, 1.0E-7);
    }

    /**
     */
    @Test
    public void testMove3() {
        randomWalk rw = new randomWalk();
        double root2 = Math.sqrt(2);
        rw.move(1, 1);
        assertEquals(rw.distance(), root2, 1.0E-7);
        rw.move(1, 1);
        assertEquals(rw.distance(), 2 * root2, 1.0E-7);
        rw.move(0, -2);
        assertEquals(rw.distance(), 2.0, 1.0E-7);
        rw.move(-2, 0);
        assertEquals(rw.distance(), 0.0, 1.0E-7);
    }

 

    
    @Test
   public void testDataSet() {
       
        int n1 = 700;
	int n2 = 800;
        int n3 = 900;
        int n4 = 1000;
	int n5 = 1100;
	int n6 = 1200;
		 
        int count = 100000;
			
		 double d1=0;
		 double s1=0;
                 double q1=0;
                 double d2=0;
		 double s2=0;
                 double q2=0;
                 double d3=0;
		 double s3=0;
                 double q3=0;
                 double d4=0;
		 double s4=0;
                 double q4=0;
                 double d5=0;
		 double s5=0;
                 double q5=0;
                 double d6=0;
		 double s6=0;
                 double q6=0;
                 
		 
		 for (int i=1;i<=count; i++) {
			randomWalk walk = new randomWalk();
                        d1 = walk.randomWalk(n1);
			s1 += d1;
                        q1 += d1*d1;
			d2 = walk.randomWalk(n2);
                        s2 +=d2;
                        q2 += d2*d2;
                        d3 = walk.randomWalk(n3);
			s3 +=d3;
                        q3 += d3*d3;
			d4 = walk.randomWalk(n4);
                        s4 +=d4;
                        q4 += d4*d4;
			d5 = walk.randomWalk(n5);
                        s5 += d5;
                        q5 += d5*d5;
			d6 = walk.randomWalk(n6);
                        s6 += d6;
                        q6 += d6*d6;
			}
                 
		 s1 = s1/count;
		 s2 = s2/count;
		 s3 = s3/count;
		 s4 = s4/count;
		 s5 = s5/count;
		 s6 = s6/count;
                 
                 q1 = q1/count;
		 q2 = q2/count;
		 q3 = q3/count;
		 q4 = q4/count;
		 q5 = q5/count;
		 q6 = q6/count;
		 
	     System.out.println(n1 + " steps: " +s1+"   distance square:"+q1);
	     System.out.println(n2 + " steps: " +s2+"   distance square:"+q2);
	     System.out.println(n3 + " steps: " +s3+"   distance square:"+q3);
	     System.out.println(n4 + " steps: " +s4+"   distance square:"+q4);
	     System.out.println(n5 + " steps: " +s5+"   distance square:"+q5);
	     System.out.println(n6 + " steps: " +s6+"   distance square:"+q6);
             
             System.out.println("-------------------------------------------------------");
             System.out.println("Conclusion:");
             System.out.println("It can be seen from the result that when the test is repeated as much as possible");
             System.out.println("the average value of distance square tends to be equal to N. ");
    }
    
}
