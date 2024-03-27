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

public class CheapKrabs {
    public static void main(String[] args) throws Exception {
        new CheapKrabs().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("CheapKrabs").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			int n = f.nextInt();
			f.nextLine();
			int[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int[] diff = new int[n-1];
			for (int i = 0; i < diff.length; i++) {
				diff[i] = Math.abs(ar[i]-ar[i+1]);
			}
			int max = 0;
			for (int i = 0; i < diff.length; i++) {
				int N = 1, run = 0;
				for (int j = i; j < diff.length; j++) {
					N++;
					run+=diff[j];
					max = Math.max(N-run,max);
				}
			}
			out.println(max);
		}
        f.close();
    }
}
