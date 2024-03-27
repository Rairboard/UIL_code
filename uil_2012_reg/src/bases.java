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

public class bases {
    public static void main(String[] args) throws Exception {
        new bases().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bases").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		int n = f.nextInt();
        int[] base = {10,2,4,8,12,16};
		int[] len = new int[base.length];
		List<List<String>> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			al.add(new ArrayList<>());
		}
		for (int i = 1;i <= n; i++) {
			for (int j = 0; j < base.length; j++) {
				String ln = Integer.toString(i,base[j]);
				len[j] = Math.max(len[j],ln.length());
				al.get(i-1).add(ln);
			}
		}
		for (int i = 0; i < len.length; i++) {
			len[i] = Math.max(("Base " + base[i]).length(),len[i]);
			len[i]+=3;
		}
		out.printf("%-" + len[0] + "s%-" + len[1]+"s%-" + len[2]+"s%-" + len[3] + "s%-" + len[4]+"s%-" + len[5]+"s\n","Base 10","Base 2","Base 4","Base 8","Base 12","Base 16");
		for (int i = 0; i < al.size(); i++) {
			for (int j = 0; j < base.length; j++) {
				out.printf("%-"+len[j] + "s",al.get(i).get(j));
			}
			out.println();
		}
        f.close();
    }
}
