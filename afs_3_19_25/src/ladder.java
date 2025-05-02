import java.util.*;
import java.io.*;
public class ladder {
	public static void main(String[] args)throws Exception {
		new ladder().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("test"));
//        Scanner f = new Scanner(System.in);
        int n = f.nextInt(), m = f.nextInt();
        f.nextLine();
        List<String> al = new ArrayList<>(List.of(f.nextLine().trim().split("\\s+")));
        boolean[][] connected = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = i+1;j<n;j++){
                int diff = 0;
                for (int k = 0; k < al.get(i).length(); k++) {
                    if(al.get(i).charAt(k) != al.get(j).charAt(k)){
                        diff++;
                    }
                }
                if(diff==1){
                    connected[i][j] = connected[j][i] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int a = al.indexOf(f.next());
            int b = al.indexOf(f.next());
            int[] shadow = new int[n];
            Arrays.fill(shadow, Integer.MAX_VALUE);
            shadow[a] = 1;
            PriorityQueue<state> pq = new PriorityQueue<>();
            pq.offer(new state(a, 1));
            while(!pq.isEmpty()){
                state cur = pq.remove();
                int u = cur.u;
                int w = cur.w;
                if(w>shadow[u]) continue;
                for(int v =0; v< n;v++){
                    if(connected[u][v] && w + 1 < shadow[v]){
                        shadow[v] = w + 1;
                        pq.offer(new state(v, w+1));
                    }
                }
            }
            System.out.println(Arrays.toString(shadow));

            System.out.println(shadow[b] == Integer.MAX_VALUE ? "Not Connected.":shadow[b]);
        }
        f.close();
	}
    class state implements Comparable<state>{
        int u;
        int w;
        public state(int u, int w){
            this.u = u;
            this.w = w;
        }
        public int compareTo(state o){
            return w - o.w;
        }
    }
}
