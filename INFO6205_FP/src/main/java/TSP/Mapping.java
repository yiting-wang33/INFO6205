package TSP;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Yiting Wang 001205751
 * @Date: Created on 2018/4/5
 * Store the data(cities) in a Map
 **/
public class Mapping {
    private static Mapping instance=null;
    public Map<Integer,City> cities=new HashMap();
    private Mapping(){}
    public static Mapping getInstace(){
        if(instance==null)
            instance=new Mapping();
        return instance;
    }

    public void ShowCities(){
        for(int i:cities.keySet())
            System.out.println("Key="+i+" "+cities.get(i).showCity());
    }
}
