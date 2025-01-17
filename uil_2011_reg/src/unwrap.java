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

public class unwrap {
    public static void main(String[] args) throws Exception {
        new unwrap().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("unwrap").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        f.nextLine();
        int[][] m = new int[n][n];
        boolean[][] v = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int top = 0, left = 0, bottom = n-1, right = n-1;
        List<Integer> al = new ArrayList<>();
        while(top<=bottom&&left<=right){

            for(int i = left;i<=right;i++){
                if(!v[top][i]) {
                    al.add(m[top][i]);
                    v[top][i] = true;
                }
            }
            top++;
            for(int i = top;i<=bottom;i++){
                if(!v[i][right]){
                    al.add(m[i][right]);
                    v[i][right] = true;
                }
            }
            right--;
            for(int i = right;i>=left;i--){
                if(!v[bottom][i]){
                    al.add(m[bottom][i]);
                    v[bottom][i] = true;
                }
            }
            bottom--;
            for(int i = bottom;i>=top;i--){
                if(!v[i][left]){
                    al.add(m[i][left]);
                    v[i][left] = true;
                }
            }
            left++;
        }
        while(!al.isEmpty()){
            for(int i =0 ;i < 10 && !al.isEmpty();i++){
                out.print(al.remove(0) +" ");
            }
            out.println();
        }
        f.close();
    }
}
