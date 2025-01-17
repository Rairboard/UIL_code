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

public class excellent {
    public static void main(String[] args) throws Exception {
        new excellent().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("excellent").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int one = f.nextInt(), two = f.nextInt();
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        f.nextLine();
        for (int i = 0; i < one; i++) {
            a.add(f.nextLine().trim());
        }
        for (int i = 0; i < two; i++) {
            b.add(f.nextLine().trim());
        }
        TreeSet<String> ts1 = new TreeSet<>();
        TreeSet<String> ts2 = new TreeSet<>();
        for(String s : a){
            if (!b.contains(s)) {
                ts1.add(s);
            }
        }
        for(String s :b){
            if (!a.contains(s)) {
                ts2.add(s);
            }
        }
        out.println("NAMES IN SPREADSHEET 1 THAT ARE NOT IN SPREADSHEET 2");
        for(String s : ts1){
            out.println(s);
        }
        out.println("NAMES IN SPREADSHEET 2 THAT ARE NOT IN SPREADSHEET 1");
        for(String s : ts2){
            out.println(s);
        }
        f.close();
    }
}
