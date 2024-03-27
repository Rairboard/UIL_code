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

public class brandon {
    public static void main(String[] args) throws Exception {
        new brandon().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("brandon").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            double b = f.nextDouble();
            b*=b;
            if(b%2==0){
                out.println((int)b);
            }
            else{
                out.printf("%.1f\n",b);
            }
        }
        f.close();
    }
}
