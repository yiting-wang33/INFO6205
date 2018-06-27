package GA_TSP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author: Sirui Fu 001836759
 * @Date: Created on 2018/4/6
 * Genetic Algorithms
 * Parameters：
 * 1.max_generation=10000,
 * 2.ini_population=1000
 * 3.fecundity of mating=2
 * 4.generations to reproductive maturity=1
 * 5.proportion of organisms that survive and breed,survive_rate=0.5. Mortality=1-survive_rate.
 * 6.proportion of mutation,mutation_rate=1%=0.01
 * 7.Map father, collection of father
 * 8.Map offspring，collection of offsprings
 * 9.Best_Result, stores every evolving genotype.
 * 10.init_Generation(int l),initialize the first generation.
 *11.ExistCheck(Genotype i, Map<Integer,Genotype>m), check if the i is already in the Map m.
 * 12.SurviveBreed(), eliminate the worst genotypes according to the survive_rate.
 * 13.Best(), show the best genotype.
 * 14.CrossOver(Genotype g1, Genotype g2), let 2 genotypes hybridize
 * 15.nextGeneration(), use father to generate offspring
 * 16.MergeFatherOffspring(), combine father and offspring
 * 17.ChangeGenePosition(), change the position of two genes on one genotype randomly
 * 18.Mutation(), use ChangeGenePosition() to mutate one genotype.
 *
 **/
public class GA_TSP {
    private int ini_population=1000;
    private int max_generation=10000;
    public double survive_rate=0.5;
    public Map<Integer,Genotype> father=new HashMap();//collection of every father of one generation
    public Map<Integer,Genotype> offspring=new HashMap();//collection of every offspring of one generation
    public double mutation_rate=0.001;
    public int fecundity=2;//fecundity of mating,2 offsprings per pair
    public Genotype g0;
    public Map<Double,Integer> Best_Results=new HashMap();
    public int count=0;

    public void init_Generation(Genotype i0){
        this.g0=i0;
        Genotype geno;
        while(father.size()<ini_population){
            int[] g=i0.genotype.clone();
            g=Shuffle(g);
            geno=new Genotype(g);
            if(ExistCheck(geno,father)){
                continue;
            }
            else {
                father.put(father.size(),geno);
            }
        }
    }

    public boolean ExistCheck(Genotype i,Map<Integer,Genotype>m){
        boolean flag=false;
        for(Integer k:m.keySet()) {
            if (Arrays.equals(m.get(k).genotype,i.genotype)) {
                flag = true;
                break;
            }
            else continue;
        }
        return flag;
    }

    public void SurvivetoBreed(){
        int size=father.size();
        int out=(int)((1-this.survive_rate)*size);
        double[] fitness=new double[size];
        Map<Integer,Double>m=new HashMap();
        for(int k=0;k<father.size();k++) {
            fitness[k]=father.get(k).phenotype.Fitness();
        }
        for(int i=0;i<fitness.length;i++)
            m.put(i,fitness[i]);
        Arrays.sort(fitness);
        for(int i=0;i<out;i++) {
            for(int k:m.keySet())
                if(m.get(k)==fitness[i])
                    father.remove(k);
        }
        Map<Integer,Genotype> m1=new HashMap();
        for(int k:father.keySet())
            m1.put(k,father.get(k));
        int i=0;
        father.clear();
        for(int k:m1.keySet()){
            father.put(i,m1.get(k));
            i++;
        }
    }

    public String Best(){
        Genotype min=father.get(0);
        for(int k:father.keySet()){
            if(father.get(k).phenotype.Distance()<=min.phenotype.Distance())
                min=father.get(k);
            else continue;
        }
        if(!Best_Results.keySet().contains(min.phenotype.Distance()))
            Best_Results.put(min.phenotype.Distance(),count);
        count++;
        return "Best Path:"+min.phenotype.Path()+"\nShortest Distance="+min.phenotype.Distance()+"\n";
    }

    //g1.x+g2.x,g1.y+g2.y
    public Genotype[] CrossOver(Genotype g1,Genotype g2){
        g1.Chromosome();
        Genotype[] sons=new Genotype[this.fecundity];
        g1.i_Chromosome(g2);
        int[] son1=new int[g1.length];
        int[] son2=new int[g1.length];
        Map<Integer,Integer> s1=new HashMap();
        Map<Integer,Integer> s2=new HashMap();
        for(int k:g1.chromosomeX.keySet()){
            s1.put(s1.size(),g1.chromosomeX.get(k));
        }
        for(int k:g2.chromosomeX.keySet()){
            s1.put(s1.size(),g2.chromosomeX.get(k));
        }
        for(int i=0;i<s1.size();i++)
            son1[i]=s1.get(i);
        for(int k:g1.chromosomeY.keySet()){
            s2.put(s2.size(),g1.chromosomeY.get(k));
        }
        for(int k:g2.chromosomeY.keySet()){
            s2.put(s2.size(),g2.chromosomeY.get(k));
        }
        for(int i=0;i<s2.size();i++)
            son2[i]=s2.get(i);
        sons[0]=new Genotype(son1);
        sons[1]=new Genotype(son2);
        return sons;
    }

    public void nextGeneration(){
        this.offspring.clear();
        if(father.size()%2!=0) {
            int[] g=this.g0.genotype.clone();
            g=Shuffle(g);
            Genotype g_=new Genotype(g);
            father.put(father.size(),g_);
        }
        else
        for(int i=0;i<father.size()/2;i++){
            int f1=i;int f2=i+father.size()/2;
            Genotype[] sons;
            sons=CrossOver(father.get(f1),father.get(f2));
            offspring.put(offspring.size(),sons[0]);
            offspring.put(offspring.size(),sons[1]);
        }
    }

    public void MergeFatherOffspring(){
        for(int k:offspring.keySet())
            father.put(father.size(),offspring.get(k));
    }

    //make two random genes change their positions
    public void ChangeGenePosition(Genotype g){
        Random r=new Random();
        int pos1=r.nextInt(g.length);
        int pos2=pos1;
        while(pos2==pos1)
            pos2=r.nextInt(g.length);
        int chg=g.genotype[pos1];
        g.genotype[pos1]=g.genotype[pos2];
        g.genotype[pos2]=chg;
    }

    public void Mutation(){
        Random r=new Random();
        int num=(int)(this.mutation_rate*offspring.size());
        if(num>0) {
            Map<Integer, Integer> m = new HashMap();
            int i = r.nextInt(offspring.size());
            m.put(i, i);
            while (m.size() < num) {
                while (m.values().contains(i))
                    i = r.nextInt(offspring.size());
                m.put(i, i);
            }
            for (int k : m.keySet())
                ChangeGenePosition(offspring.get(k));
        }
    }

    public int[] Shuffle(int[] a){
        Random r=new Random();
        for(int i=0;i<a.length;i++){
            int chg=r.nextInt(i+1);
            int exp=a[i];
            a[i]=a[chg];
            a[chg]=exp;
        }
        return a;
    }

    public void ShowEvolution(){
        int[] generation=new int[Best_Results.size()];
        int i=0;
        Map<Integer,Double>m=new HashMap();
        for(double d:Best_Results.keySet()) {
            m.put(Best_Results.get(d), d);
        }
        for(int k:m.keySet()) {
            generation[i]=k;
            i++;
        }
        Arrays.sort(generation);
        System.out.println("\nShow Evolution");
        for(int p=0;p<generation.length;p++)
            System.out.println("Generation=" + generation[p] + " Value=" + m.get(generation[p]));
    }

    public void setIni_population(int p){
        this.ini_population=p;
    }
    public int getIni_population(){
        return this.ini_population;
    }
    public void setMax_generation(int m){
        this.max_generation=m;
    }
    public int getMax_generation(){
        return this.max_generation;
    }
    public void setSurvive_rate(double s){
        this.survive_rate=s;
    }
    public void setMutation_rate(double m){this.mutation_rate=m;}
    public String printArray(double[] a){
        String s="";
        for(int i=0;i<a.length;i++){
            s+=a[i]+" ";
        }
        return s;
    }
    public String printArray(int[] a){
        String s="";
        for(int i=0;i<a.length;i++){
            s+=a[i]+" ";
        }
        return s;
    }
    public void ShowFather(){
        for(int k:father.keySet())
            System.out.println("Father key="+k+" value="+father.get(k).phenotype.Path()+" distance="+father.get(k).phenotype.Distance());
        System.out.println();
    }

    public void ShowOffspring(){
        for(int k:offspring.keySet())
            System.out.println("Offspring key="+k+" value="+offspring.get(k).phenotype.Path()+" distance="+offspring.get(k).phenotype.Distance());
        System.out.println();
    }
}
