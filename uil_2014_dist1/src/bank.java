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

public class bank {
    public static void main(String[] args) throws Exception {
        new bank().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bank").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().split("[^0-9]");
            long sum = 0;
            String print = "";
            for (int i = 0; i < ln.length; i++) {
                if(ln[i].isEmpty()) continue;
                sum+=Long.parseLong(ln[i]);
                print+=Long.parseLong(ln[i]) + " ";
            }
            if(print.isEmpty()){
                out.println("-");
            }
            else{
                out.println(print);
            }
            out.println(sum);
        }
        f.close();
    }
}
