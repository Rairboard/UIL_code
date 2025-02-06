import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class helen {
    public static void main(String[] args) throws Exception {
        new helen().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("helen").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln= f.nextLine().trim().split("\\s+");
            if (ln[0].matches(".*[a-z].*")) {
                String constant = ln[0].replaceAll("[^a-z]","");
                long coefficient = 1;
                if(!ln[0].replaceAll("[a-z]","").isEmpty()){
                    coefficient = Long.parseLong(ln[0].replaceAll("[a-z]",""));
                }
                long a = Long.parseLong(ln[2]), b = Long.parseLong(ln[4]);
                switch (ln[1]){
                    case "+" -> b-=a;
                    case "-" -> b+=a;
                    case "/" -> b *=a;
                    case "*" -> b/=a;
                }
                out.printf(constant+" = %.3f\n" , (double)b/coefficient);
            }
            if (ln[2].matches(".*[a-z].*")) {
                String constant = ln[2].replaceAll("[^a-z]","");
                long coefficient = 1;
                if(!ln[2].replaceAll("[a-z]","").isEmpty()){
                    coefficient = Long.parseLong(ln[2].replaceAll("[a-z]",""));
                }
                long a = Long.parseLong(ln[0]), b = Long.parseLong(ln[4]);
                switch (ln[1]){
                    case "+" -> b-=a;
                    case "-" -> b = a-b;
                    case "/" -> b = a/b;
                    case "*" -> b/=a;
                }

                out.printf(constant+" = %.3f\n", (double)b/coefficient);
            }
            if (ln[4].matches(".*[a-z].*")) {
                String constant = ln[4].replaceAll("[^a-z]","");
                long coefficient = 1;
                if(!ln[4].replaceAll("[a-z]","").isEmpty()){
                    coefficient = Long.parseLong(ln[4].replaceAll("[a-z]",""));
                }
                long a = Long.parseLong(ln[0]), b = Long.parseLong(ln[2]);
                switch (ln[1]){
                    case "+" -> b+=a;
                    case "-" -> b = a-b;
                    case "/" -> b = a/b;
                    case "*" -> b*=a;
                }
                out.printf(constant+" = %.3f\n", (double)b/coefficient);
            }
        }
        f.close();
    }
}
