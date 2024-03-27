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

public class lucie {
    public static void main(String[] args) throws Exception {
        new lucie().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("lucie").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String pos = f.nextLine();
			int r = Integer.parseInt(pos.substring(0,pos.indexOf(","))), c = Integer.parseInt(pos.substring(pos.indexOf(",")+1));
			long[][] val = new long[r][c];
			for (int i = 0; i < r; i++) {
				val[i] = Arrays.stream(f.nextLine().trim().split(",")).mapToLong(Long::parseLong).toArray();
			}
			long[][] m = new long[c+1][r+1];
			for (int i = 0; i < r; i++) {
				long colSum = 0;
				for (int j = 0; j < c; j++) {
					m[j][i] = val[i][j];
					colSum+=val[i][j];
				}
				m[c][i] = colSum;
			}
			for (int i = 0; i < c; i++) {
				long rowSum = 0;
				for (int j = 0; j < r; j++) {
					rowSum+=val[j][i];
				}
				m[i][r] = rowSum;
			}
			for (int i = 0; i < m.length; i++) {
				String ln ="";
				for (int j = 0; j < (i == m.length-1?m[i].length-1:m[i].length); j++) {
					ln+=m[i][j]+",";
				}
				out.println(ln.substring(0,ln.length()-1));
			}
			out.println("*".repeat(12));
        }
        f.close();
    }
}
