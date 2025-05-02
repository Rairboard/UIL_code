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

public class callen {
    public static void main(String[] args) throws Exception {
        new callen().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("callen").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			out.println(" ".repeat(7) + "Wind Speeds");
			int a = f.nextInt(), b = f.nextInt(), rstep = f.nextInt();
			int c = f.nextInt(), d = f.nextInt(), cstep = f.nextInt();
			int sr = Math.max(a,b), er = Math.min(a,b);
			int sc = Math.min(c,d), ec = Math.max(c,d);
			out.print("  Temps");
			for(int i = sc;i<=ec;i+=cstep){
				out.printf("%7d", i);
			}
			out.println();
			for(int i = sr;i>=er;i-=rstep){
				out.printf("%7d", i);
				for(int j = sc;j<=ec;j+=cstep){
					double ans = 35.74 +0.6215 * i - 35.75 * Math.pow(j, .16) + .4275 * i * Math.pow(j, .16);
					out.printf("%7.1f", ans);
				}
				out.println();
			}
			out.println("*".repeat(25));
		}
        f.close();
    }
}
