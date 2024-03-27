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

public class serpentine {
	int[][]m;
	boolean[][]v;
    public static void main(String[] args) throws Exception {
        new serpentine().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("serpentine").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int N = f.nextInt();
			int num = 1,top = 0, left = 0, right = N-1,bottom = N-1;
			m = new int[N][N];
			v = new boolean[N][N];
			while(top<=bottom && left<=right){
				for (int i = bottom; i >= top;i--) {
					m[i][left] = num++;
				}
				left++;
				for (int i = left;i<=right; i++) {
					m[top][i] = num++;
				}
				top++;
				for(int i = right;i>=left;i--){
					m[top][i] = num++;
				}
				top++;
				for(int i=top;i<=bottom;i++){
					m[i][left] = num++;
				}
				left++;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					out.printf("%-" + (Integer.toString(num-1).length()+1)+ "d",m[i][j]);
				}
				out.println();
			}
			out.println();
        }
        f.close();
    }
}
