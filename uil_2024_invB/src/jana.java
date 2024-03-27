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

public class jana {
    public static void main(String[] args) throws Exception {
        new jana().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("jana").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int d = f.nextInt();
            char[][] m = new char[d][d];
            for (int i = 0; i < d; i++) {
                Arrays.fill(m[i],' ');
            }
            for (int i = 0; i <= d/2; i+=2) {
                int left = i, top = i, right = d-i-1, bottom = d-i-1;
                for(int j = left;j<=right;j++){
                    m[top][j] = '#';
                }
                top++;
                for(int j = top;j<=bottom;j++){
                    m[j][right] = '#';
                }
                right--;
                for(int j =right;j>=left;j--){
                    m[bottom][j] = '#';
                }
                bottom--;
                for(int j = bottom;j>=top;j--){
                    m[j][left] = '#';
                }
            }
            for(char[] cc : m){
                out.println(cc);
            }
            out.println();
        }
        f.close();
    }
}
