import java.util.*;
import java.io.File;
import java.util.Arrays;

import static java.lang.System.*;

public class babydriverlvl2_ThanhLe {
    char[][] m;
    int[][] shadow;
    int[][] police;
    int min;
    boolean solved;
    public static void main(String[] args) throws Exception {
        new babydriverlvl2_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("babydriverlvl2").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        f.nextLine();
        for (int asdf = 0; asdf < n; asdf++) {
            int r = f.nextInt(), c = f.nextInt(), coor = f.nextInt();
            f.nextLine();
            m = new char[r][c];
            shadow = new int[r][c];
            police = new int[r][c];
            min = Integer.MAX_VALUE;
            List<int[]> policePos = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                Arrays.fill(police[i], Integer.MAX_VALUE);
                m[i] = f.nextLine().trim().toCharArray();
                for (int j = 0; j < c; j++) {
                    if(m[i][j]=='P'){
                        policePos.add(new int[]{i,j});
                    }
                }
            }
            for(int[] pos: policePos){
                fill(pos[0],pos[1], 0);
            }
            for(int ll = 0;ll < coor;ll++){
                int R = f.nextInt(), C = f.nextInt();
                for (int i = 0; i < r; i++) {
                    Arrays.fill(shadow[i],Integer.MAX_VALUE);
                }
                solved = false;
                recur(R,C,0);
                out.println(solved?"We're gonna make it out!":"We're a little cooked.");
            }
            out.println();
        }
        f.close();
    }
    public void fill(int r, int c, int step){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length && step < police[r][c] && m[r][c]!='#'){
            police[r][c] = step;
            fill(r-1,c,step+1);
            fill(r+1,c,step+1);
            fill(r,c-1,step+1);
            fill(r,c+1,step+1);
        }
    }
    public void recur(int r, int c, int step){
        if(r>=0&&c>=0&& r < m.length && c < m[r].length && step < shadow[r][c] && step < police[r][c]&&m[r][c]!='#' && m[r][c] != 'P'){
            if(m[r][c]=='E'){
                solved = true;
                return;
            }
            shadow[r][c] =step;
            recur(r-1,c,step+1);
            recur(r+1,c,step+1);
            recur(r,c-1,step+1);
            recur(r,c+1,step+1);
        }
    }
}
