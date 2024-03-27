import java.util.*;
import java.io.*;

public class kitchen {
    char[][] m;
    int[][] shadow;
    boolean solved;
    int min;
    public static void main(String[] args) throws Exception {
        new kitchen().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("kitchen.dat"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            int r=f.nextInt(),c=f.nextInt();
            f.nextLine();
            int sr = 0, sc = 0;
            boolean O = false, S = false;
            m = new char[r][c];
            shadow = new int[r][c];
            solved = false;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < r; i++) {
                String s = f.nextLine();
                m[i] = s.toCharArray();
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
                if(s.contains("O")){
                    O = true;
                }
                if(s.contains("S")){
                    S = true;
                    sr = i;
                    sc = s.indexOf("S");
                }
            }
            if(!O || !S){
                System.out.println("Don't bother showing up.");
            }else{
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m[i].length; j++) {
                        if(m[i][j] == 'G'){
                            for (int nr = i-2; nr <= i+2; nr++) {
                                for (int nc = j-2; nc <= j+2; nc++) {
                                    if(nr >= 0 && nr < m.length && nc >= 0 && nc < m[nr].length && m[nr][nc] != 'G'){
                                        m[nr][nc] = '#';
                                    }
                                }
                            }
                        }
                    }
                }
//                for(char[] cc:m){
//                    System.out.println(cc);
//                }
                recur(sr,sc,0);
                System.out.println(solved?"Very good chef.":"Don't bother showing up.");
            }
        }
        f.close();
    }
    public void recur(int r, int c, int step){
        if(step < min && r>=0 && c>=0 && r<m.length && c<m[r].length && step < shadow[r][c] && m[r][c] != '#'){
            if(m[r][c] == 'O'){
                solved = true;
                min = Math.min(min,step);
            }else{
                shadow[r][c] = step;
                char save = m[r][c];
                m[r][c] = '#';
                recur(r-1,c,step+1);
                recur(r+1,c,step+1);
                recur(r,c-1,step+1);
                recur(r,c+1,step+1);
                m[r][c] = save;
            }
        }
    }
}