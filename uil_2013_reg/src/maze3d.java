import java.util.*;
import java.io.*;

public class maze3d {
    static char[][][] m;
    static int[][][] shadow;
    int minStep;
    boolean found;

    public static void main(String[] args) throws Exception {
        new maze3d().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("maze3d.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r = f.nextInt(),c = f.nextInt(), l = f.nextInt();
            int sl = 0, sr = 0, sc = 0;
            minStep = Integer.MAX_VALUE;
            m = new char[l][r][c];
            shadow  = new int[l][r][c];
            f.nextLine();
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    m[i][j] = f.nextLine().toCharArray();
                    Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
                    for (int k = 0; k < c; k++) {
                        if(m[i][j][k] == 'S'){
                            sl = i;
                            sr = j;
                            sc = k;
                        }
                    }
                }
            }
            found = false;
            recur(sl,sr,sc,0, 3);
            System.out.println(found? minStep + " MOVES" :"STUCK" );
        }
        f.close();
    }
    public void recur(int l, int r, int c,int step, int b){
        if(step < minStep && l>=0 && l<m.length && r>=0 && r<m[l].length && c>=0 && c<m[l][r].length && m[l][r][c] != '#' && step < shadow[l][r][c] ){
            if(m[l][r][c] == 'E'){
                found = true;
                minStep  = step;
                return;
            }
            if(m[l][r][c] == '*' && b==0){
                return;
            }
            char save = m[l][r][c];
            if(m[l][r][c] == '*'){
                b-=1;
            }
            shadow[l][r][c] = step;
            m[l][r][c] = '#';
            recur(l+1,r,c,step+1,b);
            recur(l,r+1,c,step+1,b);
            recur(l,r-1,c,step+1,b);
            recur(l,r,c+1,step+1,b);
            recur(l,r,c-1,step+1,b);
            recur(l-1,r,c,step+1,b);
            m[l][r][c] = save;
        }
    }
}
