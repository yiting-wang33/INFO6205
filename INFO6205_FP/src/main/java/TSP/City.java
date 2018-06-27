package TSP;

/**
 * @Author: Yiting Wang 001205751
 * @Date: Created on 2018/4/5
 * Pseudo-Euclidean Distance: d=((x1-x2)^2+(y1-y2)^2)/10)^0.5
 **/
public class City {
    private double[] city_pos=new double[2];
    private int city_num;

    public City(double x,double y,int num){
        this.city_pos[0]=x;
        this.city_pos[1]=y;
        this.city_num=num;
    }
    public City(double[] pos,int num){
        this.city_pos=pos;
        this.city_num=num;
    }
    public int getCity_num(){
        return this.city_num;
    }
    public void setCity_posX(double x){
        this.city_pos[0]=x;
    }
    public void setCity_posY(double y){
        this.city_pos[1]=y;
    }
    public void setCity_pos(double[] city_pos) {
        this.city_pos = city_pos;
    }
    public double getCity_posX(){
        return city_pos[0];
    }
    public double getCity_posY() { return city_pos[1]; }
    public String showCity(){
        return "City num="+city_num+" "+"City Pos="+"("+city_pos[0]+","+city_pos[1]+")";
    }
    public double distance(City c){
        double x=c.getCity_posX()-this.getCity_posX();
        double y=c.getCity_posY()-this.getCity_posY();
        return Math.sqrt((x*x+y*y)/10);
    }
}
