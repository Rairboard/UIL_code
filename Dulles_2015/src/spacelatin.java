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

public class spacelatin {
    public static void main(String[] args) throws Exception {
        new spacelatin().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("spacelatin.in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String[] l = f.nextLine().replaceAll("\\.","").split("\\s+");
            for (int i = 0; i < l.length; i++) {
                l[i] = l[i].toLowerCase();
                if (!l[i].equals("I") && !l[i].matches("[aeiouy].*")) {
                    String nv = l[i].replaceAll("[^aeiouy]","");
                    String sub = l[i].substring(0,l[i].indexOf(nv.charAt(0)));
                    l[i] = l[i].substring(l[i].indexOf(nv.charAt(0))) + sub + "oy";
                }
            }
            for (int i = 0; i <l.length; i++) {
                if(i==0){
                    out.print(l[i].substring(0,1).toUpperCase() + l[i].substring(1) + " ");
                }
                else if(i==l.length-1){
                    out.println(l[i] + ".");
                }
                else{
                    out.print(l[i] + " ");
                }
            }
        }
        f.close();
    }
}
