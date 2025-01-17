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

public class sunil {
    public static void main(String[] args) throws Exception {
        new sunil().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sunil").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int row = f.nextInt();
			int col = f.nextInt();
			double sum = 0 ;
			if(f.hasNext()) f.nextLine();
			double[][] m = new double[row][col];
			double[] ROW = new double[row];
			double[] COL = new double[col];
			for (int i = 0; i < row; i++) {
				m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					ROW[i]+=m[i][j];
				}
				sum+=ROW[i];
				ROW[i]/=col;
			}
			for(int j = 0;j < col;j++){
				for (int i = 0; i < row; i++) {
					COL[j]+=m[i][j];
				}
				COL[j]/=row;
			}
			for (int i = 0; i < row; i++) {
				out.printf("%8.2f", ROW[i]);
			}
			out.println();
			for (int i = 0; i < col; i++) {
				out.printf("%8.2f", COL[i]);
			}
			out.println();
			out.printf("%8.2f\n", sum/(row*col));
			out.println("=".repeat(25));
        }
        f.close();
    }
}
