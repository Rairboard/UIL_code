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

public class koolaid {
    public static void main(String[] args) throws Exception {
        new koolaid().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("koolaid.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			double N = f.nextLong() * .5;
			double[] l = {2,1,.5};
			String[] s = {"large","medium","small"};
            String res = "";
			for (int i = 0; i < l.length; i++) {
                if(N >= l[i]){
                    res += (int)(N/l[i]) + " " + s[i] + " ";
                    N%=l[i];
                }
			}
            if(!res.trim().isEmpty()){
                out.println(res.trim());
            }
        }
        f.close();
    }
}
