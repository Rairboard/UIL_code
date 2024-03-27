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

public class adv109 {
    public static void main(String[] args) throws Exception {
        new adv109().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("adv109").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt();
			int dm = 1;
			while(dm*dm<n){
				dm++;
			}
			char[][] m = new char[dm][dm];
			String s = "";
			for (int i = 0; i < dm*dm; i++) {
				if(i >= n || i >= 26){
					s+="*";
				}
				else{
					s+=(char)('A' + i);
				}
			}
			int top = 0, left = 0, right = dm-1, bottom = dm -1;
			while(bottom>=top&&right>=left){
				for(int i = left;i<=right;i++){
					m[bottom][i] = s.charAt(0);
					s = s.substring(1);
				}
				bottom--;
				for(int i = bottom;i>=top;i--){
					m[i][right] = s.charAt(0);
					s = s.substring(1);
				}
				right--;
				for(int i = right;i>=left;i--){
					m[top][i] = s.charAt(0);
					s = s.substring(1);
				}
				top++;
				for(int i = top;i<=bottom;i++){
					m[i][left] = s.charAt(0);
					s = s.substring(1);
				}
				left++;
			}
			for(char[] cc : m){
				out.println(new String(cc));
			}
			out.println();
        }
        f.close();
    }
}
