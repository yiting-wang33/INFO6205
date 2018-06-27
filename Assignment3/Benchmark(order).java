/*
 * Copyright (c) 2018. Phasmid Software
 */

package simplesort;



import java.util.Random;
import java.util.function.Function;

public class Benchmark<T> {

    public Benchmark(Function<T, Void> f) {
        this.f = f;
    }

    public double run(T t, int m, Sort<Integer> sorter) {
    	    
    	    int n = ((Integer) t).intValue();
    	    long starttime = 0;
    	    long endtime = 0;
    	    Integer[] a = new Integer[4000];
    	    Random ran = new Random();
    	    long x = 0;
    		for (int i=1;i<=m;i++) {
            /**
    			for (int j = 0; j<4000; j++) {
        			a[j]=new Integer(ran.nextInt());
    		    }
    		    */
    		
    		    /**
    			for (int j = 0; j<4000; j++) {
        			a[j] = 1000-j;
    		    }
            */
    		
    			for (int j = 0; j < 4000; j++) a[j] = j;
    			
    		    
    			
    	    	    	starttime = System.nanoTime();
    	    	    	sorter.sort(a,0,n);
    	    	    	endtime = System.nanoTime();
    	    	    	boolean ifordered = true;
    	    	    	x = x+(endtime-starttime);
    		}
    		//System.outs.println("Starttime:"+starttime+"   Endtime:"+endtime);
        return x/m;  // TODO
    }

    private final Function<T, Void> f;

    public static void main(String[] args) {
        int m = 100; // This is the number of repetitions: sufficient to give a good mean value of timing
        // TODO populate the array with real random data
        int n ;
        Integer[] array = new Integer[4000];
        for (int i = 0; i < 4000; i++) array[i] = i;
        System.out.println("Runing time of reverse-ordered arrays:");
		System.out.println("n      SelectionSort:                    InsertionSort:");
        for (int i=0; i<=4;i++) {
        	    n = (int) (200*Math.pow(2,i));
        		// TODO You need to apply doubling to n
            String Txt1 = String.format("%1$15.2f", benchmarkSort(array, n, "SelectionSort", new SelectionSort<>(), m));
            String Txt2 = String.format("%1$15.2f", benchmarkSort(array, n, "InsertionSort", new InsertionSort<>(), m));
        		System.out.println(n+" "+Txt1+"             "+Txt2);
        }
    }

    private static double benchmarkSort(Integer[] xs, Integer n, String name, Sort<Integer> sorter, int m) {
    	    double time = 0;
    	    double xx = 0;
    	    double xxx;
        Function<Integer, Void> sortFunction = (x) -> {
            sorter.sort(xs, 0, x);
            return null;
        };
        Benchmark<Integer> bm = new Benchmark<>(sortFunction);
        for (int i=1;i<=50;i++) 
    		     xx = bm.run(n, m, sorter);
        
        for (int i=1;i<=50;i++) {
        		xxx = bm.run(n, m, sorter);
        		time +=xxx;
        }
        time = time/50;
        //System.out.println(name + ": " + time + " nanosecs for n=" + n);
        return time;
        
        
    }
}