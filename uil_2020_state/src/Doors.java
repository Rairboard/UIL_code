import java.util.*;
import java.io.File;

public class doors {
    int[][][] shadow;
    char[][] m;
    public static void main(String[] args) throws Exception {
        new doors().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("doors").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while(times-->0){
            int row = f.nextInt(), col = f.nextInt(), s = f.nextInt();
            int sr = -1, sc = 1, er =-1, ec = -1;
            f.nextLine();
            m = new char[row][col];
            int key = 0;
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().trim().toCharArray();
                for (int j = 0; j < col; j++) {
                    if(m[i][j]==']'){
                        sr = i;
                        sc = j;
                    }
                    else if(m[i][j]=='['){
                        er = i;
                        ec = j;
                    } else if (Character.isLowerCase(m[i][j])) {
                        key++;
                    }
                }
            }
            shadow = new int[1 << key][row][col];
            for (int i = 0; i < shadow.length; i++) {
                for (int j = 0; j < row; j++) {
                    Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
                }
            }
            recur(sr,sc,0,0);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < shadow.length; i++) {
                min = Math.min(shadow[i][er][ec],min);
            }
            if(min==Integer.MAX_VALUE || er == -1 && ec == -1 || min > s){
                System.out.println("Mother knows best.");
            }
            else {
                System.out.println("Amazeing Job. Escaped in " + min + " steps.");
            }
        }
        f.close();
    }
    public void recur(int r, int c, int k, int step){
        if(r>=0&&c>=0&&k>=0&&r<m.length&&c<m[r].length&&k<shadow.length&&step<shadow[k][r][c]&&m[r][c]!='#'){
            if(Character.isUpperCase(m[r][c]) && (k & 1 << m[r][c]-'A') == 0) return;
            shadow[k][r][c] = step;
            if(Character.isLowerCase(m[r][c])) k |= 1 << (m[r][c]-'a');
            recur(r-1,c,k,step+1);
            recur(r+1,c,k,step+1);
            recur(r,c-1,k,step+1);
            recur(r,c+1,k,step+1);
        }
    }
}
