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

public class brittany {
    public static void main(String[] args) throws Exception {
        new brittany().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("brittany").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        double sum = 0;
        int cnt = 0;
        while(f.hasNext()){
            sum+=f.nextDouble();
            cnt++;
        }
        out.printf("%.2f %.2f\n",sum, sum/cnt);
        f.close();
    }
}
