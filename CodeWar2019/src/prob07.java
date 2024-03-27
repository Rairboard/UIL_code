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

public class prob07 {
    public static void main(String[] args) throws Exception {
        new prob07().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("prob07").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
		while (f.hasNext()) {
			long N = f.nextLong(), M = f.nextLong();
			if(M==0){
				while(true){
					N++;
					if(N%2==0){
						out.println(N);
						break;
					}
				}
			}
			else if(M==1){
				BigInteger b = BigInteger.valueOf(N);
				out.println(b.nextProbablePrime());
			}
			else if(M==2){
				long a = (long)Math.sqrt(N) + 1;
				out.println(a*a);
			}
			else if(M==3){
				long a = (long)Math.cbrt(N) + 1;
				out.println(a*a*a);
			}
		}
        f.close();
    }
}
