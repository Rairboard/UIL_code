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

public class smooth {
    public static void main(String[] args) throws Exception {
        new smooth().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("smooth").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int n = f.nextInt(), sub=(f.nextInt()-1)/2;
		f.nextLine();
		int[][] m = new int[n][n];
		for (int i = 0; i < n; i++) {
			m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		}
		for(int i = 0;i < n;i++){
			for(int j = 0;j < n;j++){
				double total = 0;
				int cnt = 0;
				for(int r = i-sub;r<=i+sub;r++){
					for(int c = j-sub;c<=j+sub;c++){
						if(r>=0&&c>=0&&r<n&&c<n){
							total+=m[r][c];
							cnt++;
						}
					}
				}
				out.print(Math.round(total/cnt) + " ");
			}
			out.println();
		}
        f.close();
    }
}
