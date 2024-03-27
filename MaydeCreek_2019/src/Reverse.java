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

public class Reverse {
    public static void main(String[] args) throws Exception {
        new Reverse().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Reverse").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while (f.hasNext()) {
            String[] ar = f.nextLine().split("\\s+");
            List<String> al = new ArrayList<>();
            for (int i = 0; i < ar.length; i++) {
                if(ar[i].toLowerCase().matches("[aieou].*")){
                    al.add(ar[i]);
                }
            }
            Collections.reverse(al);
            for (int i = 0; i < ar.length; i++) {
                if(ar[i].toLowerCase().matches("[aieou].*")){
                    ar[i] = al.remove(0);
                }
            }
            for (int i = 0; i < ar.length; i++) {
                out.print(ar[i] + " ");
            }
            out.println();
        }
        f.close();
    }
}
