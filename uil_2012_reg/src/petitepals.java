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

public class petitepals {
    public static void main(String[] args) throws Exception {
        new petitepals().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("petitepals").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String ln = f.nextLine();
            HashSet<String> hs = new HashSet<>();
            for (int i = 0; i < ln.length(); i++) {
                for (int j = i+1; j <= ln.length(); j++) {
                    if(ln.substring(i,j).equals(new StringBuilder(ln.substring(i,j)).reverse().toString()) && ln.substring(i,j).length() <= ln.length()-1){
                        hs.add(ln.substring(i,j));
                    }
                }
            }
            out.println(hs.size());
        }
        f.close();
    }
}
