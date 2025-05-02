import java.util.*;
import java.io.*;
public class gopher {
    char[][][] m;
    int[][][] shadow;
    int[] vr = {-1,1,0,0};
    int[] vc = {0,0,-1,1};
	public static void main(String[] args)throws Exception {
//        System.out.println(Arrays.toString("aaabaaaaa".split("a")));
		new gopher().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("gopher.dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            m = new char[2][row][col];
            int sr = -1, sc = -1, er = -1, ec = -1;
            shadow = new int[2][row][col];
            for (int l = 0; l < 2; l++) {
                for (int i = 0; i < row; i++) {
                    Arrays.fill(shadow[l][i], Integer.MAX_VALUE);
                    m[l][i] = f.nextLine().trim().toCharArray();
                    for (int j = 0; j < col; j++) {
                        if(m[l][i][j] == 'H'){
                            sr = i;
                            sc = j;
                        }
                        else if(m[l][i][j] == 'G'){
                            er = i;
                            ec = j;
                        }
                    }
                }
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            q.offer(sr);
            q.offer(sc);
            q.offer(0);
            while(!q.isEmpty()){
                int l = q.remove(), r = q.remove(), c = q.remove(), step  = q.remove();
                if(r<0||r>=row || c<0 || c>=col) continue;
                if(m[l][r][c]=='#') continue;
                if(step>=shadow[l][r][c]) continue;
                shadow[l][r][c] = step;
                if(m[l][r][c]=='O'&&m[l^1][r][c]=='O'){
                    q.offer(l^1);
                    q.offer(r);
                    q.offer(c);
                    q.offer(step);
                }
                for (int i = 0; i < 4; i++) {
                    q.offer(l);
                    q.offer(r + vr[i]);
                    q.offer(c + vc[i]);
                    q.offer(step+1);
                }
            }
            if(shadow[0][er][ec]==Integer.MAX_VALUE){
                System.out.println("Nowhere left to go-pher.");
            }
            else System.out.println(shadow[0][er][ec]);
        }
        f.close();
	}
    public void recur(int l, int r, int c, int step ){
        if(r<0||c<0||r>=m[l].length||c>=m[l][r].length||m[l][r][c]=='#') return;
        if(step>=shadow[l][r][c]) return;
        shadow[l][r][c] = step;
        if(m[l][r][c]=='O' && m[l^1][r][c] =='O'){
            recur(l^1,r,c,step);
        }
        for (int i = 0; i < 4; i++) {
            recur(l, r + vr[i], c + vc[i], step+1);
        }
    }
}
