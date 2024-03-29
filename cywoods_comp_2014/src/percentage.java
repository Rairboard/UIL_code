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

public class percentage {
    public static void main(String[] args) throws Exception {
        new percentage().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("percentage").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			double p = f.nextDouble();
			f.nextLine();
			double[] ar =  Arrays.stream(f.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
			double avg = 0;
			for (int i = 0; i < ar.length; i++) {
				avg+=ar[i];
			}
			avg/=ar.length;
			double percent = Math.abs((avg-p)/p) * 100;
			if(percent<5){
				out.println("Accurate");
			}
			else{
				out.println("Inaccurate");
			}
        }
        f.close();
    }
}
