import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class OrbitSynchronization {
    public static void main(String[] args) throws Exception {
        new OrbitSynchronization().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("OrbitSynchronization").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
		long[] ar = new long[times];
		long lcm = (long)Math.pow(10,9);
		for (int i = 0; i < times; i++) {
			ar[i] = f.nextLong();
			lcm = Math.min(ar[i],lcm);
		}

		while(true){
			boolean good = true;
			for (int i = 0; i < times; i++) {
				if(lcm%ar[i]!=0){
					good = false;
				}
			}
			if(good) break;
			lcm++;
		}
		out.println(lcm);
		for (int i = 0; i < times; i++) {
			out.print(lcm/ar[i]+" ");
		}
        f.close();
    }
}
