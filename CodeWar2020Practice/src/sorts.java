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

public class sorts {
    public static void main(String[] args) throws Exception {
        new sorts().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sorts").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            List<Item> al = new ArrayList<>();
            double total = 0;
            for (int i = 0; i < n; i++) {
                String[] ln = f.nextLine().split("\\s+");
                double price = Double.parseDouble(ln[ln.length-2]);
                int numItem = Integer.parseInt(ln[ln.length-1]);
                String name = "";
                for (int j = 0; j < ln.length - 2; j++) {
                    name+=ln[j]+" ";
                }
                al.add(new Item(name.trim(),price,numItem));
            }
            Collections.sort(al);
            for (int i = 0; i < al.size(); i++) {
                out.println(al.get(i));
                total+=al.get(i).price * al.get(i).num;
            }
            out.printf("Total Revenue: %.2f\n",  total);
        }
        f.close();
    }
    class Item implements Comparable<Item>{
        int num;
        double price;
        String n;
        public Item(String name, double pr, int N){
            n = name;
            price = pr;
            num = N;
        }
        public int compareTo(Item o){
            return Double.compare(o.num * o.price,num*price);
        }
        public String toString(){
            return String.format("%s %.2f %d Revenue: %.2f",n,price,num,price * num);
        }
    }
}
