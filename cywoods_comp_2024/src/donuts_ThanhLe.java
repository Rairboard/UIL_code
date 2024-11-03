import java.util.*;
import java.io.File;

public class donuts_ThanhLe {
    public static void main(String[] args) throws Exception {
        new donuts_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("finding_judge").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt(), m = f.nextInt(), k = f.nextInt();
            f.nextLine();
            boolean[][] v = new boolean[n+2][n+2];
            int[] shadow = new int[n+2];
            int[] DONUT = new int[n+2];
            Arrays.fill(shadow,Integer.MAX_VALUE);
            for (int i = 1;i <= n; i++) {
                DONUT[i] = f.nextInt();
            }
            for (int i = 0; i < m; i++) {
                int a = f.nextInt(), b = f.nextInt();
                v[a][b] = true;
                v[b][a] = true;
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            q.offer(0);
            while(!q.isEmpty()){
                int cur = q.remove(), donuts = q.remove();
                if(donuts>=shadow[cur]) continue;
                shadow[cur] = donuts;
                for(int i = 0; i < v[cur].length;i++){
                    if(v[cur][i]){
                        q.offer(i);
                        q.offer(donuts + DONUT[cur]);
                    }
                }
            }
            System.out.println(shadow[n+1] + k);
        }
        f.close();
    }
}
