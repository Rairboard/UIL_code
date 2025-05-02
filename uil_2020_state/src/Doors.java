import java.util.*;
import java.io.File;

public class doors {
    public static void main(String[] args) throws Exception {
        new doors().run();
    }
    char[][]m;
    int[][][] shadow;
    int[] vr = {-1,1,0,0};
    int[] vc = {0,0,-1,1};
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("doors").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while(times-->0){
            int row = f.nextInt(), col = f.nextInt(), maxStep = f.nextInt();
            int sr = -1, sc = -1, er = -1, ec = -1;
            f.nextLine();
            m = new char[row][col];
            int key = 0;
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().toCharArray();
                for (int j = 0; j < col; j++) {
                    if(m[i][j]==']'){
                        sr = i;
                        sc = j;
                    }
                    else if(m[i][j] == '['){
                        er = i;
                        ec = j;
                    }
                    else if ((m[i][j] + "").matches("[a-z]")) {
                        key++;
                    }
                }
            }
            shadow = new int[1 << key][row][col];
            for (int i = 0; i < 1 << key; i++) {
                for (int j = 0; j < row; j++) {
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                }
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(sr);
            q.offer(sc);
            q.offer(0);
            q.offer(0);
            while(!q.isEmpty()){
                int r = q.remove(), c = q.remove(), k = q.remove(), step = q.remove();
                if(r<0||c<0||r>=row||c>=col||m[r][c]=='#' || step>= shadow[k][r][c]) continue;
                if((m[r][c]+"").matches("[A-Z]") && (k & 1 << m[r][c]-'A')==0) continue;
                shadow[k][r][c] = step;
                if((m[r][c]+"").matches("[a-z]")) k|= 1 << m[r][c] - 'a';
                shadow[k][r][c] = step;
                for (int i = 0; i < 4; i++) {
                    int nr = r + vr[i];
                    int nc = c + vc[i];
                    q.offer(nr);
                    q.offer(nc);
                    q.offer(k);
                    q.offer(step+1);
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 1 << key; i++) {
                min = Math.min(min, shadow[i][er][ec]);
            }
            if(min<=maxStep) System.out.println("Amazeing Job. Escaped in " + min + " steps.");
            else System.out.println("Mother knows best.");
        }
        f.close();
    }
}
