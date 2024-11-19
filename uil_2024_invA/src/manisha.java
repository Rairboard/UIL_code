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

public class manisha {
    public static void main(String[] args) throws Exception {
        new manisha().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("manisha").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String[] ln = f.nextLine().replaceAll("\\s+","").split("\\+");
            List<Item> al = new ArrayList<>();
            for (int i = 0; i < ln.length; i++) {
                List<Individual> asdf = new ArrayList<>();
                for (int j = 0; j < ln[i].length(); j++) {
                    if(ln[i].charAt(j)=='/'){
                        asdf.add(new Individual(ln[i].substring(j,j+2)));
                        j++;
                    }
                    else{
                        asdf.add(new Individual(ln[i].substring(j,j+1)));
                    }
                }
                Collections.sort(asdf);
                String word = "";
                for(Individual in : asdf){
                    word+=in.name;
                }
                al.add(new Item(word));
            }
            Collections.sort(al);
            for (int i = 0; i < al.size(); i++) {
                if(i<al.size()-1){
                    out.print(al.get(i).name+"+");
                }
                else{
                    out.println(al.get(i).name);
                }
            }
        }
        f.close();
    }
    class Item implements Comparable<Item>{
        String name;
        int s;
        String without;
        public Item(String n){
            name = n;
            s = n.indexOf("/");
            without = name.replaceAll("/","");
        }
        public int compareTo(Item o){
            if (without.length() == o.without.length()) {
                if (without.compareTo(o.without)==0) {
                    return s - o.s;
                }
                return without.compareTo(o.without);
            }
            return without.length() - o.without.length();
        }
    }
    class Individual implements Comparable<Individual>{
        String name;
        int s;
        String without;
        public Individual(String n){
            name = n;
            s = name.indexOf("/");
            without = n.replaceAll("/","");
        }
        public int compareTo(Individual o){
            if(without.compareTo(o.without)==0){
                return s - o.s;
            }
            return without.compareTo(o.without);
        }
    }
}
