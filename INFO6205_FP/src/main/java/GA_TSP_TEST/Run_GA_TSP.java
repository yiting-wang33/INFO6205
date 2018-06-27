package GA_TSP_TEST;

import GA_TSP.*;
import ReadData.ReadCityMapIO;
import TSP.Mapping;

/**
 * @Author: Sirui Fu 001836759
 * @Date: Created on 2018/4/9
 **/
public class Run_GA_TSP {
    public static void Run(){
        ReadCityMapIO.LoadData("coor.txt");
        Mapping m=Mapping.getInstace();
        int size=m.cities.size();
        GA_TSP ga=new GA_TSP();
        ga.setSurvive_rate(0.5);//survive_rate
        ga.setMutation_rate(0.001);//mutation_rate
        ga.setMax_generation(10000);//max_generation
        ga.setIni_population(1000);//population of the first father collection
        int[] t0=new int[size];
        for(int i=0;i<size;i++)
            t0[i]=i;
        Genotype g0=new Genotype(t0);//the very first genotype

        //use the first father genotype to initialize the very first father collection
        ga.init_Generation(g0);

        System.out.println("The first generation:");
        System.out.println(ga.Best());

        for(int i=0;i<ga.getMax_generation();i++){
            System.out.println("Generation "+(i+1)+":");
            //generate the next generation
            ga.nextGeneration();
            //mutation
            ga.Mutation();
            //combine father and offspring
            ga.MergeFatherOffspring();
            //eliminate the worst genotypes
            ga.SurvivetoBreed();
            //store the best genotype
            ga.Best();
        }
        ga.ShowEvolution();
        System.out.println("\n"+ga.Best());
    }
}
