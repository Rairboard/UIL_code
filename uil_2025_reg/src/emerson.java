import java.util.*;
import java.io.*;
public class emerson {
	public static void main(String[] args)throws Exception {
		new emerson().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("emerson.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int row = f.nextInt(), col = f.nextInt(), charge = f.nextInt();
            f.nextLine();
            char[][] m = new char[row][col];
            int[][][] shadow = new int[charge+1][row][col];
            int[][] coor= new int[2][2];
            for(int[] each : coor) Arrays.fill(each, -1);
            List<int[]> shark = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                m[i] = f.next().trim().toCharArray();
                for (int j = 0; j <= charge; j++) {
                    Arrays.fill(shadow[j][i], Integer.MAX_VALUE);
                }
                for (int j = 0; j < col; j++) {
                    if(m[i][j]=='S') coor[0] = new int[]{i,j};
                    if(m[i][j]=='E') coor[1] = new int[]{i,j};
                    if("<>v^".contains(m[i][j]+"")) shark.add(new int[]{i,j,m[i][j]});
                }
            }
            String dir = "v^><";
            int[] vr = {-1,1,0,0,-1,-1,1,1};
            int[] vc = {0,0,-1,1,-1,1,-1,1};
            for(int[] p : shark){
                int r = p[0], c = p[1], d = dir.indexOf((char)p[2]);
                for(int k = 1;k<=2;k++){
                    int nr = r + vr[d]* k;
                    int nc = c + vc[d]*k;
                    if (in(nr, nc, row, col)) {
                        if(m[nr][nc]=='#') break;
                        else m[nr][nc] = (char)p[2];
                    }
                }
            }
            boolean good = true;
            for(int[] each : coor){
                if(each[0] == -1 && each[1] == -1){
                    good = false;
                    break;
                }
            }
            if(!good){
                System.out.println(-1);
            }
            else{
                Queue<Integer> q = new LinkedList<>();
                q.offer(coor[0][0]);
                q.offer(coor[0][1]);
                q.offer(0);
                q.offer(0);
                while(!q.isEmpty()){
                    int r = q.remove(), c = q.remove(), step = q.remove(), ch = q.remove();
                    if(!in(r,c,row,col) || m[r][c]=='#' || "v^<>".contains(m[r][c]+"") || step>=shadow[ch][r][c]) continue;
                    shadow[ch][r][c] = step;
                    for(int i = 0;i < 4;i++){
                        int nr = r + vr[i];
                        int nc = c + vc[i];
                        q.offer(nr);
                        q.offer(nc);
                        q.offer(step+1);
                        q.offer(ch);
                    }
                    if(ch < charge){
                        for(int i = 0;i < 4;i++){
                            int nr = r + vr[i] * 2;
                            int nc = c + vc[i] * 2;
                            q.offer(nr);
                            q.offer(nc);
                            q.offer(step);
                            q.offer(ch+1);
                        }
                        for(int i = 4;i < 8;i++){
                            int nr = r + vr[i];
                            int nc = c + vc[i];
                            q.offer(nr);
                            q.offer(nc);
                            q.offer(step);
                            q.offer(ch+1);
                        }
                    }
                }
                int min = Integer.MAX_VALUE;
                for(int i = 0 ;i <= charge;i++){
                    min = Math.min(shadow[i][coor[1][0]][coor[1][1]], min);
                }
                if(min==Integer.MAX_VALUE) System.out.println(-1);
                else System.out.println(min);
            }
        }
        f.close();
	}
    public boolean in(int r, int c, int row, int col){
        return r>=0 && c>=0 && r < row && c < col;
    }
}
