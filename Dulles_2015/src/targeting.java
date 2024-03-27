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

public class targeting {
    public static void main(String[] args) throws Exception {
        new targeting().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("targeting.in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int s = f.nextInt();
            Ship us = new Ship(0,f.nextDouble(),f.nextDouble(),f.nextDouble(),0,0);
            List<Ship> al = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                int id = f.nextInt();
                double x = f.nextDouble(), y = f.nextDouble(), z = f.nextDouble(), F = f.nextDouble(), dr = f.nextDouble();
                double r =Math.sqrt(Math.pow(us.x - x,2) + Math.pow(us.y - y,2) + Math.pow(us.z - z,2));
                double threat = Math.pow(F,2) / r;
                double energy = 1.47 * r * dr;
                al.add(new Ship(id,x,y,z,threat,energy));
            }
            Collections.sort(al);
            for (int i = 0; i < 3 && i < al.size(); i++) {
                out.printf("%d %.4f\n",al.get(i).id,al.get(i).energy);
            }
        }
        f.close();
    }
    class Ship implements Comparable<Ship>{
        int id;
        double x,y,z, threat, energy;
        public Ship(int ID, double x, double y , double z,double threat, double energy){
            id = ID;
            this.x = x;
            this.y = y;
            this.z = z;
            this.threat = threat;
            this.energy = energy;
        }
        public int compareTo(Ship o){
            return Double.compare(o.threat,threat);
        }
    }
}
