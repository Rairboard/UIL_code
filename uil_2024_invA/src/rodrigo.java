import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class rodrigo {
    Map<String,List<Edge>> m;
    HashSet<String> cities;
    public static void main(String[] args) throws Exception {
        new rodrigo().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("rodrigo").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        m = new HashMap<>();
        cities = new HashSet<>();
        Map<String,City> cityMap = new HashMap<>();
        int  c= f.nextInt(), flight = f.nextInt(), limit = f.nextInt();
        f.nextLine();
        for (int i = 0; i < c; i++){
            String name = f.next();
            double tourist = f.nextDouble(),price = f.nextDouble(), att = f.nextDouble(), cul = f.nextDouble();
            cityMap.put(name,new City(name,tourist,price,att,cul));
        }
        for (int i = 0; i < flight; i++) {
            String a = f.next(), b = f.next();
            int pr = f.nextInt();
            m.putIfAbsent(a,new ArrayList<>());
            m.putIfAbsent(b,new ArrayList<>());
            m.get(a).add(new Edge(a,b,pr));
            m.get(b).add(new Edge(b,a,pr));
        }
        HashSet<String> visited = new HashSet<>();
        recur("Dallas",visited,0,limit);
        List<City> al = new ArrayList<>();
        for(String s : cities){
            al.add(cityMap.get(s));
        }
        Collections.sort(al);
        for (int i = 0; i < al.size(); i++) {
            out.println(i+1 + ": " +al.get(i).n);
        }
        f.close();
    }
    public void recur(String cur, Set<String> visited,int price,int limit){
        if(!visited.contains(cur)){
           if(m.get(cur)==null) return;
           visited.add(cur);
           if(!cur.equals("Dallas")){
               cities.add(cur);
           }
           for(Edge e : m.get(cur)){
               if(price + e.price <= limit){
                   recur(e.to,visited,price+e.price,limit);
               }
           }
           visited.remove(cur);
        }
    }
    class Edge{
        String from,to;
        int price;
        public Edge(String a, String b, int p){
            from = a;
            to =b;
            price = p;
        }
    }
    class City implements Comparable<City>{
        double att, cul, stay, tour;
        String n;
        public City(String name, double tourist, double price, double attract, double culinary){
            n = name;
            tour = tourist;
            stay =price;
            att = attract;
            cul = culinary;
        }
        public int compareTo(City o){
            if(att == o.att){
                if(cul == o.cul){
                    if(stay == o.stay){
                        if(tour == o.tour){
                            return n.compareTo(o.n);
                        }
                        return Double.compare(o.tour,tour);
                    }
                    return Double.compare(stay,o.stay);
                }
                return Double.compare(o.cul,cul);
            }
            return Double.compare(o.att,att);
        }
    }
}
