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

public class roll {
    public static void main(String[] args) throws Exception {
        new roll().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("roll").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine();
			int size = (int)Math.sqrt(ln.length());
			char[][] m = new char[size][size];
			boolean[][] adding = new boolean[size][size];
			boolean[][] remove = new boolean[size][size];
			int index = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					m[i][j] = ln.charAt(index++);
				}
			}
			for(int i = 0;i < (size % 2 == 1 ? size/2+1:size/2);i++){
				int top = i, left = i, right = size-i-1, bottom = size-i-1;
				List<Character> al = new ArrayList<>();
				for(int j = left;j<=right;j++){
					if(!adding[top][j]){
						al.add(m[top][j]);
						adding[top][j] = true;
					}
				}
				top++;
				for(int j = top;j<=bottom;j++){
					if(!adding[j][right]){
						al.add(m[j][right]);
						adding[j][right]= true;
					}
				}
				right--;
				for(int j = right;j>=left;j--){
					if(!adding[bottom][j]){
						al.add(m[bottom][j]);
						adding[bottom][j] = true;
					}
				}
				bottom--;
				for(int j = bottom;j>=top;j--){
					if(!adding[j][left]){
						al.add(m[j][left]);
						adding[j][left] = true;
					}
				}
				if(i % 2==0){
					Collections.rotate(al, -1);
				}
				else{
					Collections.rotate(al, 1);
				}
				top = left = i;
				bottom = right = size - i - 1;
				for(int j = left;j<=right;j++){
					if(!remove[top][j]){
						m[top][j] = al.remove(0);
						remove[top][j] = true;
					}
				}
				top++;
				for(int j = top;j<=bottom;j++){
					if(!remove[j][right]){
						m[j][right] = al.remove(0);
						remove[j][right]= true;
					}
				}
				right--;
				for(int j = right;j>=left;j--){
					if(!remove[bottom][j]){
						m[bottom][j] = al.remove(0);
						remove[bottom][j] = true;
					}
				}
				bottom--;
				for(int j = bottom;j>=top;j--){
					if(!remove[j][left]){
						m[j][left] = al.remove(0);
						remove[j][left] = true;
					}
				}
			}
			String ans = "";
			for(char[] cc : m){
				ans+=new String(cc);
			}
			if (ans.contains("*")) {
				out.println(ans.substring(0,ans.indexOf("*")));
			}
			else{
				out.println(ans);
			}
        }
        f.close();
    }
}
