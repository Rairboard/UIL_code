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

public class cows {
    public static void main(String[] args) throws Exception {
        new cows().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cows").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int k = f.nextInt();
		f.nextLine();
		int[][] m = new int[k][];
		int[] moo = new int[10001];
		for (int i = 0; i < k; i++) {
			int S = f.nextInt(), I = f.nextInt();
			m[i] = new int[]{S,I};
		}
		for (int i = 0; i < k; i++) {
			moo[m[i][0]]++;
		}
		for (int i = 0; i < k; i++) {
			for (int t = 1; t <= 10000/m[i][1]; t++) {
				int index = m[i][0] + m[i][1] * t;
				if(index<10001){
					moo[index]++;
				}
			}
		}
		int n = f.nextInt();
		for (int i = 0; i < n; i++) {
			int a = f.nextInt(), b = f.nextInt(), sum = 0;
			for (int t = a; t <= b; t++) {
				sum+=moo[t];
			}
			out.println(sum);
		}
        f.close();
    }
}
