package GA_TSP;

import ReadData.ReadCityMapIO;
import TSP.Mapping;

import java.util.Arrays;

/**
 * @Author: Sirui Fu
 * @Date: Created on 2018/4/5
 * Individuals have their own genotype and phenotype, and should show their adaption to the environment(condition)
 **/
public class Individual {
   public Genotype Genotype;
   public Phenotype Phenotype;
   public double fitness;

   public Individual(Genotype g){
       this.Genotype=g;
       this.Phenotype=g.phenotype;
       this.fitness=Fitness();
   }
   public Individual(int[] t){
       this.Genotype=new Genotype(t);
       this.Phenotype=this.Genotype.phenotype;
       this.fitness=Fitness();
   }

   public double Fitness()
   {
       return 1/this.Phenotype.Distance();
   }

   public boolean equals(Individual i){
       return Arrays.equals(this.Genotype.genotype,i.Genotype.genotype);
   }
}
