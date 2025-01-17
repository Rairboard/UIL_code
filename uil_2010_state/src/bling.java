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

public class bling {
    public static void main(String[] args) throws Exception {
        new bling().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bling").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
    while(f.hasNext()){
            int n= f.nextInt();
            int space = n/2;
            int star = 1;
            for(int i = 0;i < n/2+1;i++){
                out.println(" ".repeat(space) + "*".repeat(star));
                space--;
                star+=2;
            }
            space=1;
            star-=4;
            for(int i = 0;i < n/2;i++){
                out.println(" ".repeat(space) + "*".repeat(star));
                space++;
                star-=2;
            }
            out.println();
        }
        f.close();
    }
}
