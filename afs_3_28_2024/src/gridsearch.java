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

public class gridsearch {
	char[][]m;
    public static void main(String[] args) throws Exception {
        new gridsearch().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("gridsearch").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
		f.nextLine();
        m = new char[times][times];
		for (int i = 0; i < times; i++) {
			m[i] =f.nextLine().toCharArray();
		}
		int n = f.nextInt();
		f.nextLine();
		for (int i = 0; i < n; i++) {
			String ln = f.nextLine();
			String find = ln;
			// left, right, up, down
			HashSet<Integer> r = new HashSet<>();
			HashSet<Integer> c = new HashSet<>();
			for (int j = 0; j < times; j++) {
				String row = "", col = "";
				for (int k = 0; k < times; k++) {
					row+=m[j][k];
					col+=m[k][j];
					if (row.contains(ln) && !r.contains(j)) {
						find+=" "+ (j+1) + "," + (row.indexOf(ln)+1)  + ",right";
						r.add(j);
					}
					if (row.contains(new StringBuilder(ln).reverse().toString()) && !r.contains(j)) {
						find+=" " +(j+1) + "," + (k+1) + ",left";
						r.add(j);
					}
					if (col.contains(ln)&&!c.contains(j) ) {
						find+=" " + (col.indexOf(ln)+1) + "," + (j+1) + ",down";
						c.add(j);
					}
					if(col.contains(new StringBuilder(ln).reverse().toString())&&!c.contains(j)){
						find+=" " + (k+1) + "," + (j+1) + ",up";
						c.add(j);
					}
				}
			}
			out.println(find);
		}
        f.close();
    }
}
