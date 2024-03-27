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

public class joaquin {
    public static void main(String[] args) throws Exception {
        new joaquin().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("joaquin").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n = f.nextInt();
			char[][] m = new char[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(m[i],' ');
			}
			for (int i = 0; i <= n/2; i++) {
				if(i%2==0){
					int top = i, left = i, right = n-1-i, bottom = n-1-i;
					for (int j = left;j<=right; j++) {
						m[top][j] = 'X';
					}
					top++;
					for(int j = top;j<=bottom;j++){
						m[j][right] = 'X';
					}
					right--;
					for(int j = right;j>=left;j--){
						m[bottom][j] = 'X';
					}
					bottom--;
					for(int j = bottom;j>=top;j--){
						m[j][left] = 'X';
					}
				}
			}
			for(char[] c : m){
				out.println(c);
			}
			out.println("-".repeat(20));
        }
        f.close();
    }
}
