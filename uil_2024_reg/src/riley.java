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

public class riley {
    public static void main(String[] args) throws Exception {
        new riley().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("riley").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int r =f.nextInt(), c= f.nextInt();
			f.nextLine();
			double[][] m = new double[r][c];
			boolean[][] v = new boolean[r][c];
			for (int i = 0; i < r; i++) {
				m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
			}
			int left = 0, right = c-1, top = 0, bottom = r-1;
			while(left<=right && top<=bottom){
				double sum=0;
				double cnt=0;
				for(int i = left;i<=right;i++){
					if(v[top][i]) continue;
					sum+=m[top][i];
					cnt++;
					v[top][i] = true;
				}
				top++;
				for(int i =top;i<=bottom;i++){
					if(v[i][right]) continue;
					sum+=m[i][right];
					cnt++;
					v[i][right] = true;
				}
				right--;
				for(int i = right;i>=left;i--){
					if(v[bottom][i]) continue;
					sum+=m[bottom][i];
					cnt++;
					v[bottom][i] = true;
				}
				bottom--;
				for(int i = bottom;i>=top;i--){
					if(v[i][left]) continue;
					sum+=m[i][left];
					cnt++;
					v[i][left] = true;
				}
				left++;
				out.printf("%.2f ", sum/cnt);
			}
			out.println();
        }
        f.close();
    }
}
