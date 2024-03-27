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

public class patryk {
    public static void main(String[] args) throws Exception {
        new patryk().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("patryk").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        Map<String,String> m= new TreeMap<>();
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String ln = f.next();
            m.put(new StringBuilder(ln).reverse().toString(),ln);
        }
        for(String s : m.keySet()){
            out.println(m.get(s));
        }
        f.close();
    }
}
