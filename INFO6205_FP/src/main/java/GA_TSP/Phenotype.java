package GA_TSP;

import ReadData.ReadCityMapIO;
import TSP.Mapping;

/**
 * @Author: Sirui Fu
 * @Date: Created on 2018/4/6
 * fitness function is decided by the phenotype
 * Phenotype includes the distance(phenotype) and fitness(1/distance).
 *1.genotype
 *2.Distance(), calculate the distance of the genotype
 *3.Fitness(),calculate the fitness
 *4.Path(), show path according to the genotype
 **/
public class Phenotype {
    private int[] genotype;
    public double phenptype;

    public Phenotype(int[] g){
        this.genotype=g;
        this.phenptype=Distance();
    }

    public double Distance(){
        Mapping m=Mapping.getInstace();
        double distance=0;
        for(int i=0;i<genotype.length;i++){
            int city1=genotype[i%genotype.length];
            int city2=genotype[(i+1)%genotype.length];
            distance+=m.cities.get(city1).distance(m.cities.get(city2));
        }
        return distance;
    }
    public double Fitness()
    {
        return 1/this.Distance();
    }

    public String Path(){
        String path="";
        for(int i=0;i<genotype.length;i++){
            path+=genotype[i]+"->";
        }
        return path+genotype[0];
    }
}
