import GA_TSP.GA_TSP;
import GA_TSP.Genotype;
import ReadData.ReadCityMapIO;
import TSP.Mapping;
import static org.junit.Assert.assertEquals;


/**
 * @Author: Sirui Fu 001836759
 * @Date: Created on 2018/4/12
 **/
public class Test {
    Mapping map= Mapping.getInstace();
    @org.junit.Test
    public void test1(){
        ReadCityMapIO.LoadData("coor.txt");
        assertEquals(48,map.cities.size());
    }
    @org.junit.Test
    public void test2(){
        ReadCityMapIO.LoadData("coor.txt");
        int[] t1={0,1,2};
        int[] t2={2,1,0};
        Genotype g1=new Genotype(t1);
        Genotype g2=new Genotype(t2);
        assertEquals(g1.length,g2.length);
    }
    @org.junit.Test
    public void test3(){
        ReadCityMapIO.LoadData("coor.txt");
        int[] t={0,1};
        Genotype g=new Genotype(t);
        assertEquals(2989,(int)(g.phenotype.Distance()));
    }
    @org.junit.Test
    public void test4(){
        ReadCityMapIO.LoadData("coor.txt");
        int[] t1={0,1,2};
        int[] t2={2,1,0};
        Genotype g1=new Genotype(t1);
        Genotype g2=new Genotype(t2);
        assertEquals(false,g1.equals(g2));
    }
    @org.junit.Test
    public void test5(){
        ReadCityMapIO.LoadData("coor.txt");
        GA_TSP ga=new GA_TSP();
        int[] t1={0,1,2};
        int[] t2={0,1,2};
        Genotype g1=new Genotype(t1);
        Genotype g2=new Genotype(t2);
        ga.ChangeGenePosition(g1);
        assertEquals(false,g1.equals(g2));
    }
    @org.junit.Test
    public void test6(){
        ReadCityMapIO.LoadData("coor.txt");
        int[] t1={0,1,2};
        int[] t2={2,1,0};
        Genotype g1=new Genotype(t1);
        Genotype g2=new Genotype(t2);
        assertEquals(false,g1.phenotype.equals(g2.phenotype));
    }
}
