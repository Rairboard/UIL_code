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

public class connectfour {
    public static void main(String[] args) throws Exception {
        new connectfour().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("connectfour").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        out : for (int asdf = 1; asdf <= times; asdf++) {
            char[][] m = new char[6][7];
            for (int i = 0; i < m.length; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]!='-' && check(m,i,j)){
                        if(m[i][j]=='r'){
                            out.println("Red Wins");
                        }
                        else{
                            out.println("Blue Wins");
                        }
                        continue out;
                    }
                }
            }
            out.println("No win");
        }
        f.close();
    }
    public boolean check(char[][] m, int r, int c){
        int row = r-1, col = c;
        int cnt = 1;
        while(row>-1&&m[row][col]==m[r][c]){
            cnt++;
            row--;
        }
        row = r+1;
        while(row < m.length && m[row][col] == m[r][c]){
            cnt++;
            row++;
        }
        if(cnt==4) return true;

        row = r;
        cnt = 1;
        col = c-1;
        while(col>-1&&m[row][col]==m[r][c]){
            cnt++;
            col--;
        }
        col = c+1;
        while(col < m.length && m[row][col] == m[r][c]){
            cnt++;
            col++;
        }
        if(cnt==4) return true;

        cnt = 1;
        row = r-1;
        col = c-1;
        while(row > -1 && col > -1 && m[row][col] == m[r][c]){
            row--;
            col--;
            cnt++;
        }
        row = r+1;
        col = c+1;
        while(row < m.length && col < m.length && m[row][col]==m[r][c]){
            row++;
            col++;
            cnt++;
        }
        if(cnt==4) return true;

        row = r-1;
        col = c+1;
        cnt = 1;
        while(row >-1 && col < m.length && m[row][col] == m[r][c]){
            row--;
            col++;
            cnt++;
        }
        row = r+1;
        col = c-1;
        while(row < m.length && col > -1 && m[row][col] == m[r][c]){
            row++;
            col--;
            cnt++;
        }
        if(cnt==4) return true;
        return false;
    }
}
