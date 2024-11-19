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

public class harry {
    public static void main(String[] args) throws Exception {
        new harry().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("harry").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String a = f.next(), b = f.next();
            for (int i = 0; i < b.length(); i++) {
                a = a.replaceAll(b.substring(i,i+1),"");
            }
            if(a.isBlank()){
                out.println("ALL LETTERS ARE GONE");
            }
            else{
                out.println(a);
            }
        }
        f.close();
    }
}
