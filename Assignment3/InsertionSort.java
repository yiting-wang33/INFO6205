
package simplesort;


import static simplesort.Helper.*;



public class InsertionSort<X extends Comparable<X>> implements Sort<X>{
    public void sort(X[] xs,int from,int to){
        for(int i=0;i<to;i++){
            for(int j=i;j>0;j--){
                if(less(xs[j],xs[j-1]))
                    swap(xs,j,j-1);
                else break;
            }
        }
    }
}
