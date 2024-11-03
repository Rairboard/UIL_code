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

public class clothes {
    public static void main(String[] args) throws Exception {
        new clothes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("clothes").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            List<Item> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] ln = f.nextLine().trim().split("\\s+");
                al.add(new Item(ln[0], ln[1], ln[2],ln[3]));
            }
            Collections.sort(al);
            for (int i = 0; i < al.size(); i++) {
                out.println(al.get(i).name);
            }
        }
        f.close();
    }
	class Item implements Comparable<Item>{
		String name, type, color, store;
        public Item(String n, String t, String c, String s){
            name = n;
            type = t;
            color = c;
            store = s;
        }
        // type, color, store
        @Override
        public int compareTo(Item o) {
            if(type.compareTo(o.type) == 0){
                if(color.compareTo(o.color)==0){
                    return store.compareTo(o.store);
                }
                return color.compareTo(o.color);
            }
            return type.compareTo(o.type);
        }
    }
}
