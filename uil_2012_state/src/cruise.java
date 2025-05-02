import java.util.*;
import java.io.*;
public class cruise {
    String[][] m;
    int[][] shadow;
	public static void main(String[] args)throws Exception {
		new cruise().run();
	}
	public void run() throws Exception{
//        Scanner f = new Scanner(new File("cruise.dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int row = f.nextInt(), col = f.nextInt();
            int d = f.nextInt();
            f.nextLine();
            m = new String[row][col];
            shadow = new int[row][col];
            List<int[]> land = new ArrayList<>();
            int sr = -1, sc = -1;
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().trim().split("\\s+");
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
                for (int j = 0; j < m[i].length; j++) {
                    if (m[i][j].equals("S")) {
                        sr = i;
                        sc = j;
                    } else if (m[i][j].equals("L")) {
                        land.add(new int[]{i,j});
                    }
                }

            }
            int[] vr = {-1,-1,1,1,-1,1,0,0};
            int[] vc = {-1,1,-1,1,0,0,-1,1};
            Queue<Integer> q = new LinkedList<>();
            q.offer(sr);
            q.offer(sc);
            q.offer(0);
            while(!q.isEmpty()){
                int r = q.remove();
                int c = q.remove();
                int step = q.remove();
                if(step>=shadow[r][c]) continue;
                shadow[r][c] = step;
                if(m[r][c].equals("L")) continue;
                for (int i = 0; i < 8; i++) {
                    int nr = r + vr[i];
                    int nc = c + vc[i];
                    if(nr>=0&&nr<row&&nc>=0&&nc<col){
                        if(m[nr][nc].equals("L") || (Integer.parseInt(m[nr][nc])-'0')>d){
                            q.offer(nr);
                            q.offer(nc);
                            q.offer(step+1);
                        }
                    }
                }
            }
            int minCell = Integer.MAX_VALUE;
            for(int[] p : land){
                minCell = Math.min(minCell, shadow[p[0]][p[1]]-1);
            }
            System.out.println(minCell + " cells");
        }
        f.close();
	}
}
