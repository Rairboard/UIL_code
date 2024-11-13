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

public class romina {
    public static void main(String[] args) throws Exception {
        new romina().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("romina").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row =f.nextInt(), col = f.nextInt();
            if(f.hasNext())f.nextLine();
            double[][] m = new double[row][];
            boolean[][] v = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
                Arrays.fill(v[i],false);
            }
            int top = 0, left =0, bottom = row-1, right = col-1;
            double sum, cnt;
            while(top<=bottom&&left<=right){
                sum = 0;
                cnt=0;
                for(int i = left;i <=right;i++){
                    if(!v[top][i]){
                        sum+=m[top][i];
                        cnt++;
                        v[top][i] = true;
                    }
                }
                if(cnt!=0)out.printf("%.2f ", sum/cnt);
                top++;
                sum = 0;
                cnt=0;
                for(int i = top;i<=bottom;i++){
                   if(!v[i][right]){
                       sum+=m[i][right];
                       cnt++;
                       v[i][right ] = true;
                   }
                }
                if(cnt!=0)out.printf("%.2f ", sum/cnt);
                right--;
                sum = 0;
                cnt = 0;
                for(int i = right;i>=left;i--){
                    if(!v[bottom][i]){
                        sum+=m[bottom][i];
                        cnt++;
                        v[bottom][i] = true;
                    }
                }
                if(cnt!=0)out.printf("%.2f ", sum/cnt);
                bottom--;
                sum=0;
                cnt=0;
                for(int i = bottom;i>=top;i--){
                    if(!v[i][left]){
                        sum+=m[i][left];
                        cnt++;
                        v[i][left] = true;
                    }
                }
                if(cnt!=0)out.printf("%.2f ", sum/cnt);
                left++;
            }
            out.println();
        }
        f.close();
    }
}
