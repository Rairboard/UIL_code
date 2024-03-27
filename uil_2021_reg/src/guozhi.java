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

public class guozhi {
    char[][]m;
    int[][][] shadow;
    HashSet<Integer>[][] block;
    boolean found;
    int min;
    public static void main(String[] args) throws Exception {
        new guozhi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("guozhi").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt(), sr = -1, sc = -1;
            f.nextLine();
            m = new char[row][col];
            shadow = new int[4][row][col];
            found = false;
            min = Integer.MAX_VALUE;
            List<int[]> al = new ArrayList<>();
            block = new HashSet[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().toCharArray();
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]=='G'){
                        sr = i;
                        sc = j;
                    }
                    if("NSWE".contains(m[i][j]+"")){
                        al.add(new int[]{m[i][j],i,j});
                    }
                }
            }
            for (int i = 0; i < block.length; i++) {
                block[i] = new HashSet[col];
                for (int j = 0; j < block[i].length; j++) {
                    block[i][j] = new HashSet<>();
                }
            }
            for (int i = 0; i < shadow.length; i++) {
                for (int j = 0; j < shadow[i].length; j++) {
                    Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
                }
            }
            for (int i = 0; i < al.size(); i++) {
                int r ,c;
                char ch = (char)al.get(i)[0];
                if(ch=='N'){
                    for(r = al.get(i)[1],c = al.get(i)[2];r > -1;r--){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(0);
                    }
                    for(r = al.get(i)[1],c = al.get(i)[2];c < col;c++){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(1);
                    }
                    for(r = al.get(i)[1],c = al.get(i)[2];r < row;r++){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(2);
                    }
                    for(r = al.get(i)[1],c = al.get(i)[2];c > -1;c--){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(3);
                    }
                }
                else if(ch=='S'){
                    for(r = al.get(i)[1],c = al.get(i)[2];r < row;r++){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(0);
                    }
                    for(r = al.get(i)[1],c = al.get(i)[2];c > -1;c--){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(1);
                    }
                    for(r = al.get(i)[1],c = al.get(i)[2];r > -1;r--){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(2);
                    }
                    for(r = al.get(i)[1],c = al.get(i)[2];c < col;c++){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(3);
                    }
                }
                else if(ch=='E'){
                    for(r = al.get(i)[1],c = al.get(i)[2];c < col;c++){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(0);
                    }
                    for(r = al.get(i)[1],c = al.get(i)[2];r < row;r++){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(1);
                    }
                    for(r = al.get(i)[1],c = al.get(i)[2];c > -1;c--){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(2);
                    }
                    for(r = al.get(i)[1],c = al.get(i)[2];r > -1;r--){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(3);
                    }
                }
                else if(ch=='W'){
                    for(r = al.get(i)[1],c = al.get(i)[2];c > -1;c--){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(0);
                    }
                    for(r = al.get(i)[1],c = al.get(i)[2];r > -1;r--){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(1);
                    }
                    for(r = al.get(i)[1],c = al.get(i)[2];c < col;c++){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(2);
                    }
                    for(r = al.get(i)[1],c = al.get(i)[2];r < row;r++){
                        if(m[r][c]=='#'||m[r][c]=='H'){
                            break;
                        }
                        block[r][c].add(3);
                    }
                }
            }
            recur(sr,sc,0,0);
            out.println("Case #" + asdf + ": " + (found?min : -1));
        }
        f.close();
    }
    public void recur(int r, int c, int time,int wait){
        if (r >= 0 && c >= 0 && r < m.length && c < m[r].length && m[r][c] != '#' && !"NSWE".contains(m[r][c] + "") && time < shadow[time%4][r][c]) {
            if(block[r][c].contains(time%4)){
                return;
            }
            shadow[time%4][r][c] = time;
            if(m[r][c]=='H'){
                min = Math.min(min,time);
                found = true;
                return;
            }
            if(wait<4){
                recur(r,c,time+1,wait+1);
            }
            recur(r-1,c,time+1,wait);
            recur(r+1,c,time+1,wait);
            recur(r,c-1,time+1,wait);
            recur(r,c+1,time+1,wait);
        }
    }
}
