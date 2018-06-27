/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.yitingassignment2;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yitinwang
 */
public class WQUPCTest {
    
    
    
    /**
     */
    @Test
    public void testFind0() {
        WQUPC h = new WQUPC(10);
        assertEquals(0, h.find(0));
    }

    /**
     */
    @Test
    public void testFind1() {
        WQUPC h = new WQUPC(10);
        h.union(0,1);
        assertEquals(0, h.find(0));
        assertEquals(0, h.find(1));
    }

    /**
     */
    @Test
    public void testFind2() {
        WQUPC h = new WQUPC(10);
        h.union(0,1);
        assertEquals(0, h.find(0));
        assertEquals(0, h.find(1));
        h.union(2,1);
        assertEquals(0, h.find(0));
        assertEquals(0, h.find(1));
        assertEquals(0, h.find(2));
    }

    /**
     */
    @Test
    public void testFind3() {
        WQUPC h = new WQUPC(10);
        h.union(0,1);
        h.union(0,2);
        h.union(3,4);
        h.union(3,5);
        assertEquals(0, h.find(0));
        assertEquals(0, h.find(1));
        assertEquals(0, h.find(2));
        assertEquals(3, h.find(3));
        assertEquals(3, h.find(4));
        assertEquals(3, h.find(5));
        h.union(0,3);
        assertEquals(0, h.find(0));
        assertEquals(0, h.find(1));
        assertEquals(0, h.find(2));
        assertEquals(0, h.find(3));
        assertEquals(0, h.find(4));
        assertEquals(0, h.find(5));
    }

    /**
     */
    @Test
    public void testFind4() {
        WQUPC h = new WQUPC(10);
        h.union(0,1);
        h.union(0,2);
        h.union(3,4);
        h.union(3,5);
        assertEquals(0, h.find(0));
        assertEquals(0, h.find(1));
        assertEquals(0, h.find(2));
        assertEquals(3, h.find(3));
        assertEquals(3, h.find(4));
        assertEquals(3, h.find(5));
        h.union(0,3);
        assertEquals(0, h.find(0));
        assertEquals(0, h.find(1));
        assertEquals(0, h.find(2));
        assertEquals(0, h.find(3));
        assertEquals(0, h.find(4));
        assertEquals(0, h.find(5));
    }

    /**
     */
    @Test
    public void testConnected01() {
        WQUPC h = new WQUPC(10);
        assertFalse(h.connected(0,1));
    }
    
    
    @Test
    public void testDataSet() {
    double theVal;
    double err;
    
    
    for (int j=1;j<7;j++) {
        int n=j*10000;
        double s = 0;
        for (int i=0;i<100;i++) {
            int c = 0;
            int c1 = 0;
            WQUPC uf = new WQUPC(n);
            while (uf.count()!= 1) {
                Random ran = new Random();
                int p = ran.nextInt(n);
                int q = ran.nextInt(n);
                if (p == q) continue;
                c1++;
                if (uf.connected(p, q)) continue;
                uf.union(p, q);
                c++;
            }
        s +=c1;
        }
        s /=100;
        theVal = Math.log(n)*n/2;
        err= (s-theVal)/theVal*100;
        String fTxt1 = String.format("  Theoretical Value(1/2nlogn): %1$8.2f",theVal);
        String fTxt2 = String.format("  Error: %1$5.2f",err);
        System.out.println("When n = "+n+",average number of connections: "+s+fTxt1+fTxt2+"%");
        }
    }
        
    
}
