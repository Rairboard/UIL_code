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

public class difference {
    public static void main(String[] args) throws Exception {
        new difference().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("difference").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        double l = f.nextDouble();
        while(f.hasNext()){
            double d = f.nextDouble();
            if(d>90){
                l+=d-(int)d;
            }
        }
        out.println(Math.round(l));
        f.close();
    }
}
