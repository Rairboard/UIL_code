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

public class rightstuff {
    public static void main(String[] args) throws Exception {
        new rightstuff().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("rightstuff.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			double[] ar = Arrays.stream(f.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
			double tgt = ar[0], avg = 0, min = Double.MAX_VALUE, max = 0;
			boolean accurate = false, precise = false;
			for (int i = 1; i < ar.length; i++) {
				avg+=ar[i];
				min = Math.min(ar[i],min);
				max = Math.max(max,ar[i]);
			}
			avg/=ar.length-1;
			if(Math.abs((avg-tgt)/tgt)<.05){
				accurate = true;
			}
			if((max-min)/avg <= .1){
				precise = true;
			}
			if(accurate&&precise){
				out.println("Both");
			}
			else if(!accurate && !precise){
				out.println("Neither");
			}
			else if(accurate && !precise){
				out.println("Accurate");
			}
			else if(!accurate && precise){
				out.println("Precise");
			}
        }
        f.close();
    }
}
