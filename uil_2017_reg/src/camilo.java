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

public class camilo {
    public static void main(String[] args) throws Exception {
        new camilo().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("camilo").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int n = f.nextInt();
            for (int i = 1; i <=n+1; i++) {
                out.println("*".repeat(i));
            }
            if(n%2==0){
                n--;
            }
            while(n>0){
                out.println("*".repeat(n));
                n-=2;
            }
            out.println();
        }
        f.close();
    }
}
