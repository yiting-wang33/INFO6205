package simplesort;

import static simplesort.Helper.*;

public class SelectionSort<X extends Comparable<X>> implements Sort<X> {

    public void sort(X[] xs, int from, int to) {
            for (int i = 0; i < to; i++)
            { 
               int min = i;                
               for (int j = i; j < to; j++) {
                  if (less(xs[j], xs[min])) min = j;
               }
               swap(xs, i, min);
            } 
    }
}