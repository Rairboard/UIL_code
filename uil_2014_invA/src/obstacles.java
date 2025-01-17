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

public class obstacles {
    public static void main(String[] args) throws Exception {
        new obstacles().run();
    }
//    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("obstacles").toLowerCase() + ".dat"));
//        //Scanner f = new Scanner(System.in);
//        int times = f.nextInt();
//        f.nextLine();
//        for (int asdf = 1; asdf <= times; asdf++) {
//            int row= f.nextInt(), col = f.nextInt();
//            f.nextLine();
//            char[][] m = new char[row][col];
//            for (int i = 0; i < row; i++) {
//                m[i] = f.nextLine().trim().toCharArray();
//            }
//            Queue<Integer> q = new LinkedList<>();
//            q.offer(0);
//            q.offer(0);
//            int cnt = 0;
//            while(!q.isEmpty()){
//                int r =q.remove(), c = q.remove();
//                if(m[r][c]=='*') continue;
//                if(r==row-1&&c==col-1){
//                    cnt++;
//                }
//                if(r+1<row){
//                    q.offer(r+1);
//                    q.offer(c);
//                }
//                if(c+1<col){
//                    q.offer(r);
//                    q.offer(c+1);
//                }
//            }
//            out.println(cnt);
//        }
//        f.close();
//    }
    public void run() throws Exception{
        Scanner f = new Scanner(new File("obstacles.dat"));
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            char[][] m = new char[row][col];
            int[][] dp = new int[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().trim().toCharArray();
            }
            for(int i = 0;i < row;i++){
                for(int j = 0;j < col;j++){
                    if(m[i][j] == '*'){
                        dp[i][j] = 0;
                    }
                    else if(i==0 && j == 0){
                        dp[i][j] = 1;
                    }
                    else if(i==0){
                        dp[i][j] = dp[i][j-1];
                    }
                    else if(j==0){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
            out.println(dp[row-1][col-1]);
        }
    }
}
