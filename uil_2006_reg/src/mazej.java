import java.util.*;
import java.io.*;

public class mazej {
    char[][]m;
    char[][] p;
    int[][] shadow;
    List<Integer> al;
    public static void main(String[] args) throws Exception {
        new mazej().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("mazej.in"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            int c = f.nextInt(), r = f.nextInt();
            int sr = -1 ,sc = -1, er = -1, ec = -1;
            al = new ArrayList<>();
            f.nextLine();
            m = new char[r][c];
            p = new char[r][c];
            shadow = new int[r][c];
            for (int i = 0; i < r; i++) {
                String ln = f.nextLine();
                m[i] = ln.toCharArray();
                p[i] = ln.toCharArray();
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]=='@'){
                        al.add(i);
                        al.add(j);
                    }
                }
            }
            sr = al.get(0);
            sc = al.get(1);
            er =al.get(2);
            ec = al.get(3);
            recur(sr,sc,er,ec,0);
            for(char[] cc : p){
                System.out.println(cc);
            }
        }
        f.close();
    }
    public void recur(int r, int c, int R, int C, int step){
        if(r>=0&&r<m.length&&c>=0&&c<m[r].length&&step<shadow[r][c] && m[r][c]!='#' && m[r][c]!='+'){
            char save = m[r][c];
            shadow[r][c] = step;
            if(r==R && c == C){
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m[i].length; j++) {
                        if(m[i][j]=='+'){
                            p[i][j] = '@';
                        }
                        else{
                            p[i][j] = m[i][j];
                        }
                    }
                }
                p[r][c] = '@';
                return;
            }
            m[r][c] = '+';
            recur(r-1,c,R,C,step+1);
            recur(r+1,c,R,C,step+1);
            recur(r,c-1,R,C,step+1);
            recur(r,c+1,R,C,step+1);
            m[r][c] = save;
        }
    }
}