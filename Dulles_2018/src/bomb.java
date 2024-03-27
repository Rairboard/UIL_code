import java.util.*;
import java.io.File;

public class bomb {
    char[][][] m;
    int[][][] shadow;
    boolean[][][] v;
    boolean solved;
    int minBomb;
    public static void main(String[] args) throws Exception {
        new bomb().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("bomb.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int l =f.nextInt(), r = f.nextInt(), c = f.nextInt();
            f.nextLine();
            m = new char[l][r][c];
            shadow = new int[l][r][c];
            v = new boolean[l][r][c];
            int sl = -1, sr = -1,sc = -1;
            for (int ll = 0; ll < l; ll++) {
                for (int i = 0; i < r; i++) {
                    String ln = f.nextLine();
                    m[ll][i] = ln.toCharArray();
                    Arrays.fill(shadow[ll][i],Integer.MAX_VALUE);
                    Arrays.fill(v[ll][i],false);
                    if (ln.contains("S")) {
                        sl = ll;
                        sr = i;
                        sc = ln.indexOf("S");
                    }
                }
            }
            solved = true;
            minBomb = Integer.MAX_VALUE;
            recur(sl,sr,sc,0,0);
            System.out.println(minBomb);
        }
        f.close();
    }
    public void recur(int l, int r, int c, int step,int b){
        if(l>=0&&l<m.length&&r>=0&&r<m[l].length&&c>=0&&c<m[l][r].length&&!v[l][r][c]&&step<shadow[l][r][c]){
            if(m[l][r][c]=='E'){
                minBomb = Math.min(minBomb,b);
            }else{
                v[l][r][c] = true;
                shadow[l][r][c] = step;
                char save = m[l][r][c];
                if(save != '#'){
                    recur(l-1,r,c,step+1,b);
                    recur(l+1,r,c,step+1,b);
                    recur(l,r-1,c,step+1,b);
                    recur(l,r+1,c,step+1,b);
                    recur(l,r,c-1,step+1,b);
                    recur(l,r,c+1,step+1,b);
                }else{
                    recur(l-1,r,c,step+1,b+1);
                    recur(l+1,r,c,step+1,b+1);
                    recur(l,r-1,c,step+1,b+1);
                    recur(l,r+1,c,step+1,b+1);
                    recur(l,r,c-1,step+1,b+1);
                    recur(l,r,c+1,step+1,b+1);
                }
                v[l][r][c] = false;
            }
        }
    }
}
