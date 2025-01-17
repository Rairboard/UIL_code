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

public class squares {
    public static void main(String[] args) throws Exception {
        new squares().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("squares").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			int n = f.nextInt();
			char[][] m = new char[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(m[i], ' ');
			}
			for(int i = 0;i<n;i+=2){
				int top = i, left = i, right = n-1-i, bottom = n-1-i;
				for(int j = left;j<=right;j++){
					m[top][j] = '*';
				}
				top++;
				for(int j = top;j<=bottom;j++){
					m[j][right] = '*';
				}
				right--;
				for(int j = right;j>=left;j--){
					m[bottom][j] = '*';
				}
				bottom--;
				for(int j = bottom;j>=top;j--){
					m[j][left] = '*';
				}
			}
			for(char[] c : m){
				out.println(c);
			}
			out.println();
		}
        f.close();
    }
}
