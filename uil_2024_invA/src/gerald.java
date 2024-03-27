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

public class gerald {
    public static void main(String[] args) throws Exception {
        new gerald().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("gerald").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        List<Integer> al = new ArrayList<>();
        double sum = 0;
        while(f.hasNext()){
            int n = f.nextInt();
            al.add(n);
            sum+=n;
        }
        Collections.sort(al);
        double mean = sum/al.size();
        out.println("COUNT:" + al.size() + "\nSMALLEST:" + al.get(0) + "\nLARGEST:" + al.get(al.size()-1));
        out.printf("MEAN:%.1f\n",mean);
        f.close();
    }
}
