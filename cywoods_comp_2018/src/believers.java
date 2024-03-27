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

public class believers {
    public static void main(String[] args) throws Exception {
        new believers().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("believers").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int n = f.nextInt();
            int sammy = 0;
            while(n-->0){
                f.next();
                int age = f.nextInt();
                boolean b = f.nextBoolean();
                if(b){
                    sammy++;
                }
                if(!b & age <=12){
                    sammy--;
                }
            }
            out.println("Sammy Score: " + sammy);
        }
        f.close();
    }
}
