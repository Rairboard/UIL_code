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

public class door {
    char[][] m;
    int[][] shadow;
    public static void main(String[] args) throws Exception {
        new door().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("door").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt();
            int sr = -1,sc = -1;
            f.nextLine();
            m = new char[row][col];
            shadow = new int[row][col];
            for (int i = 0; i < row; i++) {
                String ln = f.nextLine().trim();
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
                if (ln.contains("S")) {
                    sr = i;
                    sc = ln.indexOf("S");
                }
                m[i] = ln.toCharArray();
            }
            recur(sr,sc,0);
            int minDoor = Integer.MAX_VALUE;
            for(int i = 0;i < row;i++){
                minDoor = Math.min(minDoor, shadow[i][0]);
                minDoor = Math.min(minDoor, shadow[i][col-1]);
            }
            for(int i = 0;i < col;i++){
                minDoor = Math.min(minDoor, shadow[0][i]);
                minDoor = Math.min(minDoor, shadow[row-1][i]);
            }
            out.println(minDoor + " door(s)");
        }
        f.close();
    }
    public void recur(int r, int c, int door){
        if(r>=0&&r<m.length&&c>=0&&c<m[r].length&&m[r][c]!='#' && door < shadow[r][c]){
            if(r == 0 || r== m.length-1 || c ==0 || c == m[r].length-1){
                if(m[r][c]=='d') {
                    shadow[r][c] = door+1;
                }
                else{
                    shadow[r][c] = door;
                }
                return;
            }
            shadow[r][c] = door;
            if(m[r][c]=='d'){
                recur(r-1,c,door+1);
                recur(r+1,c,door+1);
                recur(r,c-1,door+1);
                recur(r,c+1,door+1);
            }
            else{
                recur(r-1,c,door);
                recur(r+1,c,door);
                recur(r,c-1,door);
                recur(r,c+1,door);
            }
        }
    }
}
