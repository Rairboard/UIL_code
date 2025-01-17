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

public class octagon {
    public static void main(String[] args) throws Exception {
        new octagon().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("octagon").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int n = f.nextInt();
            int outspace = n-2;
            int inspace = n;
            out.println(" ".repeat(n-1) + "x".repeat(n));
            for(int i = 0;i < n-2;i++){
                out.println(" ".repeat(outspace) + "x" + " ".repeat(inspace) + "x");
                outspace--;
                inspace+=2;
            }
            for(int i = 0; i < n;i++){
                out.println("x" + " ".repeat(inspace) + "x");
            }
            outspace++;
            inspace-=2;
            for(int i = 0;i < n-2;i++){
                out.println(" ".repeat(outspace) + "x" + " ".repeat(inspace) + "x");
                outspace++;
                inspace-=2;
            }
            out.println(" ".repeat(outspace) + "x".repeat(n));
            out.println();
        }
        f.close();
    }
}
