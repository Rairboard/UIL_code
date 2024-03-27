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

public class blocks {
    public static void main(String[] args) throws Exception {
        new blocks().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("blocks").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int[][] b = {{1,2,3},{4,5,6},{7,8,9}};
			long n =f.nextLong()%4;
			for (long t = 0; t < n; t++) {
				int[][] copy = new int[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						copy[j][3-i-1] = b[i][j];
					}
				}
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						b[i][j] = copy[i][j];
					}
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					out.printf("%-2d",b[i][j]);
				}
				out.println();
			}
			out.println("- ".repeat(3));
        }
        f.close();
    }
}
