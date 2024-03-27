import java.util.*;
import java.io.*;

public class romero {
    static char[][] m;
    static int[][] shadow;
    static int min, dr=-1, dc=-1, gr=-1,gc=-1,t;
    boolean found;
    public static void main(String[] args) throws Exception {
        new romero().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("romero.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r = f.nextInt(), c = f.nextInt();
            t = f.nextInt();
            f.nextLine();
            int sr = 0, sc = 0;
            m = new char[r][c];
            shadow = new int[r][c];
            min = Integer.MAX_VALUE;
            found = false;
            for (int i = 0; i < r; i++) {
                m[i] = f.nextLine().toCharArray();
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
//                System.out.println(m[i]);
                for (int j = 0; j < c; j++) {
                    if(m[i][j] == 'S'){
                        sr = i;
                        sc= j;
                    }
                    if(m[i][j] == 'D'){
                        dr = i;
                        dc = j;
                    }
                    if(m[i][j] == 'G'){
                        gr = i;
                        gc = j;
                    }
                }
            }
            recur(sr,sc,0);
            System.out.println(found ? "DON’T WORRY, I’LL CARRY YOU":"BG NOOBS");
        }
        f.close();
    }
    public void recur(int r, int c, int step){
        if(step < min && r>=0 && r<m.length&&c>=0&&c<m[r].length&&step<shadow[r][c]&&m[r][c] != 'X' && m[r][c] != '+'){
//            for (int i = 0; i < m.length; i++) {
//                System.out.println(m[i]);
//            }
            if(m[r][c] == 'E'){
                min = step;
                if(t-step>=5){
                    found =true;
                }
            }
            if(m[r][c] == 'D'){
                m[r][c] ='X';
                m[gr][gc] = ' ';
                recur(gr,gc,step+3);
                m[r][c] = 'D';
            }
            else if(m[r][c] == 'G'){
                m[r][c] = 'X';
                m[dr][dc] = ' ';
                recur(dr,dc,step+3);
                m[r][c] = 'G';
            }
            else{
                char save = m[r][c];
                shadow[r][c] = step;
                m[r][c] = '+';
                recur(r,c-1,step+1);
                recur(r,c+1,step+1);
                recur(r-1,c,step+1);
                recur(r+1,c,step+1);
                m[r][c] = save;
            }
        }
    }
}
