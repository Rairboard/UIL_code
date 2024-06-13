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

public class arti {
    public static void main(String[] args) throws Exception {
        new arti().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("arti").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		int times = f.nextInt();
		while(times-->0){
			int N = f.nextInt();
			out.printf("%d %.3f\n",N,Math.sqrt(N));
		}
        f.close();
    }
}
