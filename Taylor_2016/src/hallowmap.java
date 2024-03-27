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

public class hallowmap {
    public static void main(String[] args) throws Exception {
        new hallowmap().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hallowmap").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n = f.nextInt();
			f.nextLine();
			boolean equal = false;
			char[][] orig = new char[n][n];
			char[][] m = new char[n][n];
			char[][] copy = new char[n][n];
			for (int i = 0; i < n; i++) {
				orig[i] = f.nextLine().toCharArray();
			}
			for (int i = 0; i < n; i++) {
				m[i] = f.nextLine().toCharArray();
			}
			for (int i = 0; i < 4; i++) {
				boolean match = true;
				for (int j = 0; j < n; j++) {
					if(new String(m[j]).equals(new String(orig[j]))){
						continue;
					}
					match = false;
					break;
				}
				if(!match){
					for (int x = 0; x < n; x++) {
						for (int y = 0; y < n; y++) {
							copy[x][y] = m[n-1-y][x];
						}
					}
					for (int j = 0; j < n; j++) {
						m[j] = new String(copy[j]).toCharArray();
					}
				}else{
					equal = true;
					break;
				}
			}
			out.println(equal?"Happy Trick or Treating!":"Ask Mom for another Map.");
        }
        f.close();
    }
}
