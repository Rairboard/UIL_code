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

public class rabbits {
    public static void main(String[] args) throws Exception {
        new rabbits().run();
    }

    public void run() throws Exception {
		long[] ar = new long[116];
		ar[0] = ar[1] = ar[2] = 1;
		for(int i = 3;i<=115;i++){
			ar[i] = ar[i-1] + ar[i-3];
		}
        Scanner f = new Scanner(new File(("rabbits").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			out.println(ar[f.nextInt()]);
        }
        f.close();
    }
}
