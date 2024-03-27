import java.util.*;
import java.io.File;

public class gardener_ThanhLe {
    public static void main(String[] args) throws Exception {
        new gardener_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("gardener_judge.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n = f.nextInt(), m = f.nextInt();
			boolean[][] connected = new boolean[n][n];
			for (int i = 0; i < m; i++) {
				int a = f.nextInt(), b = f.nextInt();
				connected[a][b] = true;
				connected[b][a] = true;
			}
			Queue<Integer> q = new LinkedList<>();
			HashSet<Integer> visited = new HashSet<>();
			q.offer(0);
			while (!q.isEmpty()) {
				int node = q.poll();
				visited.add(node);
				for (int i = 0; i < n; i++) {
					if(!visited.contains(i) && connected[node][i]){
						q.offer(i);
					}
				}
			}
			System.out.println(visited.size()==n && m == n-1 ? "yes":"no");
        }
        f.close();
    }
}
