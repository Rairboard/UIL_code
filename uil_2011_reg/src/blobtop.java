import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class blobtop {
    char[][] m;
    int minR, minC;
    public static void main(String[] args) throws Exception {
        new blobtop().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("blobtop").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt(), test = f.nextInt();
            f.nextLine();
            m = new char[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().trim().toCharArray();
            }
            for (int t = 0; t < test; t++) {
                int r = f.nextInt() - 1, c = f.nextInt() -1;
                if(m[r][c]!='*'){
                    out.println("NOT A BLOB");
                }
                else{
                    minR = r;
                    minC = c;
                    recur(r,c);
                    out.println(minR + 1 + " " + (minC+1));
                }
            }
        }
        f.close();
    }
    public void recur(int r, int c){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]=='*'){
            if(r<minR){
                minR = r;
                minC = c;
            } else if (r == minR){
                minC = Math.min(minC, c);
            }
            m[r][c] = '.';
            recur(r-1,c);
            recur(r+1,c);
            recur(r,c-1);
            recur(r,c+1);
            m[r][c] = '*';
        }
    }
}
