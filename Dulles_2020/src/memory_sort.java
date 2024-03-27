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

public class memory_sort {
    List<String> al = new ArrayList<>(Arrays.asList("MB GB".split(" ")));
    public static void main(String[] args) throws Exception {
        new memory_sort().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("memory_sort.dat"));
        //Scanner f = new Scanner(System.in);
        Set<Memory> s = new TreeSet<>();
        while(f.hasNext()){
            String[] l = f.nextLine().split(",");
            s.add(new Memory(l[0],l[1],l[2]));
        }
        for(Memory mm : s){
            out.println(mm);
        }
        f.close();
    }
    class Memory implements Comparable<Memory>{
        String cn, speed, size;
        int in , si, sp;
        public Memory(String name, String size,String speed){
            cn = name;
            this.size = size;
            this.speed = speed;
            in = al.indexOf(size.toUpperCase().replaceAll("[0-9]",""));
            si = Integer.parseInt(size.toUpperCase().replaceAll("[A-Z]",""));
            sp = Integer.parseInt(speed.toUpperCase().replaceAll("[A-Z]",""));
        }
        public int compareTo(Memory o){
            if(cn.compareTo(o.cn)==0){
                if(in == o.in){
                    if(si == o.si){
                        return sp < o.sp? 1 : -1;
                    }
                    return si < o.si ? 1 : -1;
                }
                return in < o.in ? 1 : -1;
            }
            return cn.compareTo(o.cn);
        }
        public String toString(){
            return cn + " - (" + size + "/" + speed + ")";
        }
    }
}
