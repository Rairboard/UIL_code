import java.util.*;
import java.io.*;

public class lawn {
    char[][]m;
    boolean[][] v;
    public static void main(String[] args) throws Exception {
        new lawn().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("lawn.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
            int r =f.nextInt(), c = f.nextInt();
            int sr = -1, sc = -1;
            f.nextLine();
            m =new char[r][c];
             v= new boolean[r][c];
            for (int i = 0; i < r; i++) {
                String ln = f.nextLine().trim();
                if (ln.contains("=")) {
                    sr = i;
                    sc = ln.indexOf("=");
                }
                m[i] = ln.toCharArray();
            }
            recur(sr, sc);
            for (int i = 0; i < m.length; i++) {
                System.out.println(new String(m[i]).replace(".","s"));
            }
            System.out.println();
        }
        f.close();
    }
    public void recur(int r, int c){
        if(r >=0 && r + 3 <= m.length&& c>=0 && c + 3 <= m[r].length){
            int haveMown = 0;
            for(int i = r;i<r+3&&i < m.length;i++){
                for(int j = c;j<c+3&&j<m[r].length;j++){
                    if(m[i][j]=='*' ) return;
                    if(m[i][j]=='B') haveMown++;
                }
            }
            if(haveMown==9) return;
            for(int i = r;i<r+3&&i < m.length;i++){
                for(int j = c;j<c+3&&j<m[r].length;j++){
                    m[i][j] = 'B';
                }
            }
            recur(r-1,c);
            recur(r+1,c);
            recur(r,c-1);
            recur(r,c+1);
        }
    }
}
