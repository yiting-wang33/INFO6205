package GA_TSP;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * @Author: Sirui Fu
 * @Date: Created on 2018/4/6
 * Genotype Class
 * Genotype is composed by all the genes. The length of the genotype equals to the amount of genes.
 * The amount of the genes equals the amount of cities.
 * Genotype is composed by genes. The length of a genotype equals to the amount of the kind of genes.
 * The amount of the kind of genes equals to the amount of the cities.
 * Every genotype has its own phenotype.
 * When two genotypes mating, they divide into two chromosomes randomly.
 **/
public class Genotype {
    public Phenotype phenotype;
    public int length;
    public int[] genotype;
    public Map<Integer,Integer> chromosomeX;
    private int[] x_key;
    public Map<Integer,Integer> chromosomeY;
    private int[] y_key;

    public Genotype(int l){
        this.length=l;
        genotype=new int[length];
        chromosomeX=new HashMap();
        chromosomeY=new HashMap();
    }
    public Genotype(int[] g){
        this.genotype=g;
        this.length=g.length;
        this.phenotype=new Phenotype(g);
        chromosomeX=new HashMap();
        chromosomeY=new HashMap();
    }

    //Generate two chromosomes,X and Y
    public void Chromosome(){
        Random r=new Random();
        Map<Integer,Integer> check=new HashMap();
        int l1=this.length/2,l2=this.length-l1;//x1=chromosomeX.size(),x2=chromosomeY.size()
        int count=0;
        this.x_key=new int[l1];//keep the genes relatively ordered.
        this.y_key=new int[l2];
        while(count<l1){
            int index=r.nextInt(this.length);
            if(check.keySet().contains(index))
                continue;
            else{
                check.put(index,index);
                x_key[count]=index;
                count++;
            }
        }
        Arrays.sort(x_key);
        for(int m=0;m<x_key.length;m++)
            chromosomeX.put(m, this.genotype[x_key[m]]);
        Map<Integer,Integer> keys=new HashMap();
        for(int m=0;m<this.length;m++)
            keys.put(m, m);
        count=0;
        while(count<l2){
            for(int key:keys.keySet()){
                if(!check.keySet().contains(key)) {
                    chromosomeY.put(count, this.genotype[key]);
                    y_key[count]=key;
                    count++;
                }
                else continue;
            }
        }
    }

    public void i_Chromosome(Genotype g){
        Map<Integer,Integer>x=new HashMap();
        Map<Integer,Integer>y=new HashMap();
        g.chromosomeX=new HashMap();
        g.chromosomeY=new HashMap();
        Map<Integer,Integer> keys=new HashMap();
        for(int i=0;i<g.genotype.length;i++) {
            keys.put(i, g.genotype[i]);
            x.put(i,g.genotype[i]);
            y.put(i,g.genotype[i]);
        }
        for(int p:this.chromosomeX.keySet())
            for(int q:keys.keySet())
                if(this.chromosomeX.get(p)==keys.get(q))
                    x.remove(q);
        for(int p:this.chromosomeY.keySet())
            for(int q:keys.keySet())
                if(this.chromosomeY.get(p)==keys.get(q))
                    y.remove(q);
        for(int k:x.keySet())
            g.chromosomeX.put(g.chromosomeX.size(),x.get(k));
        for(int k:y.keySet())
            g.chromosomeY.put(g.chromosomeY.size(),y.get(k));
    }

    public void showChromosome(){
        System.out.println("ChromosomeX:");
        for(int k:this.chromosomeX.keySet())
            System.out.println(k+" "+this.chromosomeX.get(k));
        System.out.println("ChromosomeY:");
        for(int k:this.chromosomeY.keySet())
            System.out.println(k+" "+this.chromosomeY.get(k));
    }
    public String printArray(int[] a){
        String s="";
        for(int i=0;i<a.length;i++){
            s+=a[i]+" ";
        }
        return s;
    }
    public String showGenotype(){
        String s="";
        for(int i=0;i<this.genotype.length;i++)
            s+=""+this.genotype[i]+" ";
        return s;
    }

    public boolean equals(Genotype g){
        return Arrays.equals(this.genotype,g.genotype);
    }
}
