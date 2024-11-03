import java.util.*;
import java.io.*;

public class cruz {
    char m[][];
    int shadow[][];
    int[][] floor;
    boolean solved;
    int min;
    int cnt;
    public static void main(String[] args) throws Exception {
        new cruz().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("cruz.in"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int r = f.nextInt(), c = f.nextInt(), t = f.nextInt(), limit = f.nextInt();
            f.nextLine();
            int sr = 0, sc = 0;
            min = Integer.MAX_VALUE;
            m = new char[r][c];
            shadow = new int[r][c];
            floor = new int[r][c];
            solved = false;
            cnt = 0;
            for (int i = 0; i < m.length; i++) {
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
                Arrays.fill(floor[i],Integer.MIN_VALUE);
                String ln = f.nextLine().trim();
                for (int j = 0; j < m[i].length; j++) {
                    if(ln.charAt(j)=='C'){
                        sr = i;
                        sc = j;
                    }
                    if(ln.charAt(j)=='#'){
                        cnt++;
                    }
                    m[i][j] = ln.charAt(j);
                }
            }
            recur(sr,sc,0,0);
            for (int i = 0; i < floor.length; i++) {
                System.out.println(Arrays.toString(floor[i]));
            }
            System.out.println();
            for (int i = 0; i < shadow.length; i++) {
                System.out.println(Arrays.toString(shadow[i]));
            }
            System.out.println(min * t <= limit ?"YES":"NO");
        }
        f.close();
    }
    public void recur(int r, int c, int tile, int step){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='a'){
            if(tile<=floor[r][c]) return;
            if(step>=shadow[r][c]) return;
            shadow[r][c] = step;
            floor[r][c] = tile;
            if(tile ==cnt){
                min = Math.min(min,step);
                return;
            }
            char ch = m[r][c];
            m[r][c] = 'a';
            if(ch=='#'){
                recur(r-1,c,tile+1,step+1);
                recur(r+1,c,tile+1,step+1);
                recur(r,c-1,tile+1,step+1);
                recur(r,c+1,tile+1,step+1);
            }
            else{
                recur(r-1,c,tile,step+1);
                recur(r+1,c,tile,step+1);
                recur(r,c-1,tile,step+1);
                recur(r,c+1,tile,step+1);
            }
            m[r][c] = ch;
        }
    }

}