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

public class palindrome {
    public static void main(String[] args) throws Exception {
        new palindrome().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("palindrome").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String ln = f.nextLine();
            if(ln.equals(new StringBuilder(ln).reverse().toString())){
                out.println(ln);
                for (int i = 1; i < ln.length()-1; i++) {
                    out.printf("%-"+ (ln.length()-1) + "s%s\n",ln.substring(i,i+1),ln.substring(i,i+1));
                }
                out.println(ln);
            }else{
                out.println("\"NOT A PALINDROME!\"");
            }
            out.println();
        }
        f.close();
    }
}
