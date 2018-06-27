package ReadData;
import TSP.Mapping;
import TSP.City;
import java.io.*;
/**
 * @Author: Yiting Wang 001205751
 * @Date: Created on 2018/4/6
 * Read data
 **/
public class ReadCityMapIO {
    public static void LoadData(String filename){
        Mapping map=Mapping.getInstace();
        try{
            File fn=new File(filename);
            InputStreamReader reader=new InputStreamReader(new FileInputStream(fn));
            BufferedReader in=new BufferedReader(reader);
            String line="";
            int i=0;
            while(line!=null){
                line=in.readLine();
                if(line==null)
                    break;
                double[] pos=getPos(line);
                City c=new City(pos,i);
                map.cities.put(i,c);
                i++;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static double[] getPos(String s){
        int split=s.indexOf(",");
        double x=Double.valueOf(s.substring(0,split));
        double y=Double.valueOf(s.substring(split+1));
        return new double[]{x, y};
    }
}
