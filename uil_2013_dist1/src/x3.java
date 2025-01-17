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

public class x3 {
    public static void main(String[] args) throws Exception {
        new x3().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("x3").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int a = f.nextInt(), b = f.nextInt(), c = f.nextInt(), d = f.nextInt();
            boolean found = false;
            for(int i = -100;i<=100;i++){
                if(a * Math.pow(i,3) + b * Math.pow(i,2) + c * i + d == 0){
                    found = true;
                    out.print(i + " ");
                }
            }
            if(!found) out.println("NO INTEGER SOLUTION");
            else out.println();
        }
        f.close();
    }
}
