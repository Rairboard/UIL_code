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

public class change {
    public static void main(String[] args) throws Exception {
        new change().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("change").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int n = f.nextInt() * 100;
            int[] coin = {1,5,10,25,50};
            int[][] m = new int[coin.length+1][n+1];
            for (int i = 0; i <= coin.length; i++) {
                for (int j = 0; j <= n; j++) {
                    if(i==0 && j == 0){
                        m[i][j] = 1;
                    }
                    else if(i == 0 && j > 0){
                        m[i][j] = 0;
                    }
                    else if(j == 0 && i > 0){
                        m[i][j] = 1;
                    }
                    else if(coin[i-1]<= j){
                        m[i][j] = m[i-1][j] + m[i][j-coin[i-1]];
                    }else{
                        m[i][j] = m[i-1][j];
                    }
                }
            }
            out.println(m[coin.length][n]/100);
        }
        f.close();
    }
}
