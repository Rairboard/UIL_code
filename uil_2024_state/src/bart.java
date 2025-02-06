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

public class bart {
    char[][] m;
    int[][] shadow;
    int[][] time;
    int br, bc ;
    Map<Character, List<int[]>> portal;
    public static void main(String[] args) throws Exception {
        new bart().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bart").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(),col = f.nextInt();
            f.nextLine();
            int sr = -1, sc = -1, er = -1, ec = -1;
            br = -1;bc = -1;
            m = new char[row][col];
            shadow = new int[row][col];
            time = new int[row][col];
            portal = new HashMap<>();
            List<List<int[]>> exit = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                exit.add(new ArrayList<>());
            }
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().trim().toCharArray();
                for (int j = 0; j < col; j++) {
                    if(m[i][j]=='$'){
                        sr = i;
                        sc =j;
                    }
                    else if(m[i][j]=='^'){
                        er = i;
                        ec = j;
                    }
                    else if(m[i][j]=='@'){
                        br = i;
                        bc = j;
                    }
                    else if(m[i][j]>='A'&&m[i][j]<='Z'){
                        portal.put(m[i][j],new ArrayList<>());
                    }
                    else if(m[i][j]>='a'&&m[i][j]<='z'){
                        exit.get(m[i][j]-'a').add(new int[]{i,j,m[i][j]-'a'+1});
                    }
                }
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
            }
            for(Character entry: portal.keySet()){
                for(int[] pos : exit.get(entry-'A')){
                    portal.get(entry).add(pos);
                }
            }
            int maxRadius = Math.max(row, col) - 1;
            for(int i = 2;i<=maxRadius;i++){
                int top = br - i, left = bc - i, bottom = br + i, right = bc + i;
                for(int j = left;j<=right;j++){
                    if(top>=0&&top<row && j >= 0 && j < col){
                        time[top][j] = 3 * (i-1);
                    }
                }
                for(int j = top;j<=bottom;j++){
                    if(right >=0 && right < col && j >=0 && j < row){
                        time[j][right] = 3 * (i-1);
                    }
                }
                for(int j = right;j>=left;j--){
                    if(bottom>=0&&bottom<row && j>=0&& j < col){
                        time[bottom][j] = 3 * (i-1);
                    }
                }
                for(int j = bottom;j>=top;j--){
                    if(left>=0&&left<col&&j>=0&&j<row){
                        time[j][left] = 3 * (i-1);
                    }
                }
            }
            recur(sr, sc, 0);
            if(shadow[er][ec]==Integer.MAX_VALUE){
                out.println("Tell Matthew Mcconaughey I said hi.");
            }
            else{
                out.println("Exit is short for exciting. "  + shadow[er][ec]);
            }
        }
        f.close();
    }
    public void recur(int r, int c, int t){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&t<shadow[r][c]&&!"@#".contains(m[r][c]+"")&& t-6<time[r][c]){
            shadow[r][c] = t;
            if(m[r][c]=='^') return;
            if (m[r][c] >= 'A' && m[r][c] <= 'Z') {
                for(int[] exit : portal.get(m[r][c])){
                    recur(exit[0], exit[1], t + exit[2]);
                }
            }
            if(time[r][c]<=t){
                recur(r-1,c,t+2);
                recur(r+1,c,t+2);
                recur(r,c-1,t+2);
                recur(r,c+1,t+2);
            }
            else{
                recur(r-1,c,t+1);
                recur(r+1,c,t+1);
                recur(r,c-1,t+1);
                recur(r,c+1,t+1);
            }
        }
    }
}
