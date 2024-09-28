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

public class garold {
    char ch;
    public static void main(String[] args) throws Exception {
        new garold().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("garold").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            char[][] m = new char[9][9];
            char[][] board = new char[3][3];
            int row = 0, col = 0;
            for (int i = 0; i < m.length; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            for (int r = 0; r < m.length; r+=3) {
                col=0;
                for (int c = 0; c < m[r].length; c+=3) {
                    ch = '.';
                    boolean check = win(r,c,r+3,c+3,m);
                    board[row][col] = ch;
                    col++;
                }
                row++;
            }
            ch = '.';
            boolean result = win(0,0,3,3,board);
            if(result){
                out.println("Player " + ch + " Won.");
            }
            else{
                out.println("Cat's game.");
            }
            for(char[] cc : board){
                out.println(cc);
            }
        }
        f.close();
    }
    public boolean win(int sr, int sc, int er, int ec, char[][] m){
        char[][] small = new char[3][3];
        int row = 0, col = 0;
        for(int i = sr; i<er;i++){
            col=0;
            for(int j = sc;j<ec;j++){
                small[row][col] = m[i][j];
                col++;
            }
            row++;
        }
//        for(char[] cc : small){
//            out.println(cc);
//        }
//        out.println("-".repeat(10));
        if(small[0][0] == small[0][1] && small[0][0] == small[0][2] && small[0][0] != '.'){
            ch = small[0][0];
            return true;
        }
        if(small[1][0] == small[1][1] && small[1][0] == small[1][2] && small[1][0] != '.'){
            ch = small[1][0];
            return true;
        }
        if(small[2][0] == small[2][1] && small[2][0] == small[2][2]&& small[2][0] != '.'){
            ch = small[2][0];
            return true;
        }
        if(small[0][0] == small[1][0] && small[0][0] == small[2][0]&& small[0][0] != '.'){
            ch = small[0][0];
            return true;
        }
        if(small[0][1] == small[1][1] && small[0][1] == small[2][1]&& small[0][1] != '.'){
            ch = small[0][1];
            return true;
        }
        if(small[0][2] == small[1][2] && small[0][2] == small[2][2]&& small[0][2] != '.'){
            ch = small[0][2];
            return true;
        }
        if(small[0][0] == small[1][1] && small[0][0] == small[2][2]&& small[0][0] != '.'){
            ch = small[0][0];
            return true;
        }
        if(small[0][2] == small[1][1] && small[0][2] == small[2][0]&& small[0][2] != '.'){
            ch = small[0][2];
            return true;
        }
        return false;
    }
}
