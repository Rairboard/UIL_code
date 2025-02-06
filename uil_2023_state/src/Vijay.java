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

public class Vijay {
    int[][][][] shadow;
    char[][][]m;
    public static void main(String[] args)throws Exception {
        new Vijay().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Vijay").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
           int level = f.nextInt(), row = f.nextInt(), col = f.nextInt(), o = f.nextInt(), s = f.nextInt();
           int sl = -1, sr = -1, sc = -1;
           int cd = 0;
           f.nextLine();
           m = new char[level][row][col];
           shadow = new int[1 << o][level][row][col];
           List<int[]> exit = new ArrayList<>();
            for (int i = 0; i < shadow.length; i++) {
                for (int j = 0; j < shadow[i].length; j++) {
                    for (int k = 0; k < shadow[i][j].length; k++) {
                        Arrays.fill(shadow[i][j][k],Integer.MAX_VALUE);
                    }
                }
            }
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = f.nextLine().trim().toCharArray();
                    for (int k = 0; k < m[i][j].length; k++) {
                        if(m[i][j][k]=='S'){
                            sl = i;
                            sr = j;
                            sc = k;
                        }
                        else if(m[i][j][k]=='E'){
                            exit.add(new int[]{i,j,k});
                        }
                        else if(m[i][j][k]=='O'){
                            m[i][j][k] = (char)(cd + '0');
                            cd++;
                        }
                    }
                }
            }
//            for(char[][] l : m){
//                for(char[] line : l){
//                    out.println(line);
//                }
//                out.println();
//            }

            recur(sl,sr,sc,0,0);
//            for (int i = 0; i < shadow.length; i++) {
//                for (int j = 0; j < shadow[i].length; j++) {
//                    for (int k = 0; k < shadow[i][j].length; k++) {
//                        out.println(Arrays.toString(shadow[i][j][k]));
//                    }
//                    out.println();
//                }
//                out.println("-".repeat(20));
//            }
            int min = Integer.MAX_VALUE;
            while (!exit.isEmpty()) {
                int[] ar = exit.remove(exit.size()-1);
                int l = ar[0], r = ar[1], c = ar[2];
                min = Math.min(shadow[shadow.length-1][l][r][c], min);
            }
            out.println(min <= s ? "# of steps achieved: " + min : "None shall pass.");
        }
        f.close();
    }
    public void recur(int l, int r, int c, int step,int cd){
        if(l>=0&&r>=0&&c>=0&&l<m.length&&r<m[l].length&&c<m[l][r].length&&m[l][r][c]!='#'&&step<shadow[cd][l][r][c]){
            shadow[cd][l][r][c] = step;
            if (Character.isDigit(m[l][r][c])) {
                cd |= 1 << (m[l][r][c]-'0');
            }
            shadow[cd][l][r][c] = step;
            recur(l-1,r,c,step+1,cd);
            recur(l+1,r,c,step+1,cd);
            recur(l,r-1,c,step+1,cd);
            recur(l,r+1,c,step+1,cd);
            recur(l,r,c-1,step+1,cd);
            recur(l,r,c+1,step+1,cd);
        }
    }
}
