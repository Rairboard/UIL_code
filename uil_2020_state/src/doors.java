import java.util.*;
import java.io.File;

public class doors {
    char[][] m;
    int[][][] shadow;
    int min, s;
    boolean found;
    public static void main(String[] args) throws Exception {
        new doors().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("doors").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r = f.nextInt(), c= f.nextInt(), sr = -1, sc = -1,key = 0;
            s = f.nextInt();
            f.nextLine();
            m = new char[r][c];
            min = Integer.MAX_VALUE;
            found = false;
            for (int i = 0; i < r; i++) {
                m[i] = f.nextLine().toCharArray();
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]==']'){
                        sr = i;
                        sc = j;
                    }
                    if (Character.isLowerCase(m[i][j])) {
                        key++;
                    }
                }
            }
            shadow = new int[key+1][r][c];
            for (int i = 0; i < shadow.length; i++) {
                for (int j = 0; j < shadow[i].length; j++) {
                    Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
                }
            }
            Set<Character> hs = new HashSet<>();
            recur(sr,sc,0,hs);
            if(found){
                System.out.println("Amazeing Job. Escaped in " + min + " steps.");
            }
            else{
                System.out.println("Mother know best.");
            }
        }
        f.close();
    }
    public void recur(int r, int c, int step, Set<Character> key){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#'&& step < shadow[key.size()][r][c]){
            if(Character.isUpperCase(m[r][c]) && !key.contains(Character.toLowerCase(m[r][c]))){
                return;
            }
            char save = m[r][c];
            shadow[key.size()][r][c] = step;
            if(m[r][c]=='['){
                found = true;
                min = Math.min(step,min);
                return;
            }
            if (Character.isLowerCase(save)) {
                key.add(save);
                recur(r+1,c,step+1,key);
                recur(r-1,c,step+1,key);
                recur(r,c-1,step+1,key);
                recur(r,c+1,step+1,key);
                key.remove(save);
            }
            recur(r+1,c,step+1,key);
            recur(r-1,c,step+1,key);
            recur(r,c-1,step+1,key);
            recur(r,c+1,step+1,key);
            m[r][c] = save;
        }
    }
}
