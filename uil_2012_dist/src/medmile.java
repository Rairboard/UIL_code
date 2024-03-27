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

public class medmile {
    SimpleDateFormat ff = new SimpleDateFormat("mm:ss.SS");
    public static void main(String[] args) throws Exception {
        new medmile().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("medmile").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String[] ln = f.nextLine().split("\\s+");
            List<Double> time = new ArrayList<>();
            for (int i = 1; i < ln.length; i++) {
                String[] t = ln[i].split(":");
                time.add(Integer.parseInt(t[0]) * 60 + Double.parseDouble(t[1]));
            }
            Collections.sort(time);
            if(time.size()%2==0){
                double median = (time.get(time.size()/2-1) + time.get(time.size()/2))/2;
                int min = (int)median/60;
                double sec = median%60;
                out.printf("%s %d:%05.2f\n",ln[0],min,sec);
            }else{
                double median = time.get(time.size()/2);
                int min = (int)median/60;
                double sec = median%60;
                out.printf("%s %d:%05.2f\n",ln[0],min,sec);
            }
        }
        f.close();
    }
}
