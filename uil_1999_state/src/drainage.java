import java.util.*;
import java.io.*;
public class drainage {
	public static void main(String[] args)throws Exception {
		new drainage().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("drainage.dat"));
        //Scanner f = new Scanner(System.in);
        int[] vr = {-1,1,0,0,-1,-1,1,1};
        int[] vc = {0,0,-1,1,-1,1,-1,1};
        while (f.hasNext()) {
            boolean puddle = false;
            String name = f.nextLine().trim();
            char[][] m  = new char[10][];

            for (int i = 0; i < 10; i++) {
                m[i] = f.nextLine().trim().toCharArray();
            }
            out: for (int i = 1; i < 9; i++) {
                for (int j = 1; j < 19; j++) {
                    boolean reachBorder = false;
                    Queue<Integer> q = new LinkedList<>();
                    q.offer(i);
                    q.offer(j);
                    boolean[][] visited = new boolean[10][20];
                    visited[i][j] = true;
                    queue: while(!q.isEmpty()){
                        int r = q.remove();
                        int c = q.remove();
                        for (int k = 0; k < 8; k++) {
                            int nr = r +vr[k];
                            int nc = c + vc[k];
                            if(nr>=0&&nc>=0&&nr<10&&nc<20 && !visited[nr][nc]){
                                if(nr==0 || nr == 9 || nc ==0 || nc == 19){
                                    reachBorder = true;
                                    break queue;
                                }
                                if(m[nr][nc] <= m[r][c]){
                                    visited[nr][nc] = true;
                                    q.offer(nr);
                                    q.offer(nc);
                                }
                            }
                        }
                    }
                    if(!reachBorder) {
                        puddle = true;
                        break out;
                    }
                }
            }
            System.out.println(name + " has " + (puddle?"puddled":"perfect") + " drainage.");
        }
        f.close();
	}
}
