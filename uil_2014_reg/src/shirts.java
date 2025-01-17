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

public class shirts {
    String order = "ROYGB";
    String SIZE = "SML";
    public static void main(String[] args) throws Exception {
        new shirts().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("shirts").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            List<shirt> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int id = f.nextInt();
                char color  = f.next().charAt(0);
                char size = f.next().charAt(0);
                al.add(new shirt(id, color, size));
            }
            Collections.sort(al);
            for(shirt s : al){
                out.print(s.id + " ");
            }
            out.println();
        }
        f.close();
    }
    class shirt implements Comparable<shirt>{
        int id, size,  color;
        public shirt(int id, char color, char size){
            this.id = id;
            this.color = order.indexOf(color);
            this.size = SIZE.indexOf(size);
        }
        public int compareTo(shirt o){
            if(color==o.color){
                if(size == o.size){
                    return id- o.id;
                }
                return size - o.size;
            }
            return color-o.color;
        }
    }
}
