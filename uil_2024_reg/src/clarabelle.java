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

public class clarabelle {
    public static void main(String[] args) throws Exception {
        new clarabelle().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("clarabelle").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine();
            Set<String> al = new TreeSet<>();
            for (int i = 0; i < ln.length() - 2; i++) {
                String tmp = ln.substring(i,i+3);
                if(tmp.equals(new StringBuilder(tmp).reverse().toString())){
                    al.add(tmp);
                }
            }

            if(al.isEmpty()){
                out.println("NONE");
            }
            else{
                for (String s : al) {
                    out.print(s+" ");
                }
                out.println();
            }
        }
        f.close();
    }
}