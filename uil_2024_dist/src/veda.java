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

public class veda {
    public static void main(String[] args) throws Exception {
        new veda().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("veda").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        Map<String,Double> m = new HashMap<>();
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().split(":");
            double price = Double.parseDouble(ln[1]);
            String[] letter = ln[0].split(",");
            for (int i = 0; i < letter.length; i++) {
                m.put(letter[i], price);
            }
        }
        times = f.nextInt();
        f.nextLine();
        for (int i = 0; i < times; i++) {
            String ln = f.nextLine().trim().replaceAll("[^a-zA-Z]","");
            double cost = 0;
            for (int j = 0; j < ln.length(); j++) {
                cost+=m.get(ln.substring(j,j+1));
            }
            out.printf("$%.2f\n",cost);
        }
        f.close();
    }
}
