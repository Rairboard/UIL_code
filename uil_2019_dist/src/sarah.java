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

public class sarah {
    public static void main(String[] args) throws Exception {
        new sarah().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sarah").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String ln = f.next();
            char[] c = ln.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if(i==0 && (c[i]+"").matches("[aeiou]")){
                    if(i+1<c.length){
                        char second = c[i+1];
                        c[i+1] = c[i];
                        c[i] = second;
                    }
                }
                else if(i==c.length-1 && (c[i]+"").matches("[aeiou]")){
                   char first = c[0];
                   c[0] = c[i];
                   c[i] = first;
                }
                else if((c[i]+"").matches("[aeiou]")){
                    char before = c[i-1];
                    c[i-1] = c[i+1];
                    c[i+1] = before;
                }
            }
            out.println(ln + " " + new String(c));
        }
        f.close();
    }
}
