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

public class cell {
    public static void main(String[] args) throws Exception {
        new cell().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cell").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int A = 0, B = 0;
        while(f.hasNext()){
            double N = f.nextDouble();
            A+=(int)N;
            B+=(int)Math.ceil(N);
        }
        out.println("PLAN A: " + A + "\nPLAN B: " + B);
        f.close();
    }
}
