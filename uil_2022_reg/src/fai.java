import java.util.*;
import java.io.*;

class fai {
	List<String> al;
	public static void main(String[] args) throws Exception {
		new fai().run();
	}

	public void run() throws Exception {
		// Scanner f = new Scanner(System.in);
		Scanner f = new Scanner(new File("fai.dat"));
		int times = f.nextInt();
		f.nextLine();
		for(int asdf = 1;asdf <= times;asdf++){
			al = new ArrayList<>(Arrays.asList(f.nextLine().trim().split(",")));
			int n = al.size();
			boolean[][] graph = new boolean[n][n];
			int s = al.indexOf(f.nextLine());
			String[] edges = f.nextLine().trim().split(",");
			f.nextLine();
			for (int i = 0; i < edges.length; i++) {
				String[] con = edges[i].split("<->");
				int a = al.indexOf(con[0]);
				int b = al.indexOf(con[1]);
				graph[a][b] = graph[b][a] = true;
			}
			if (isEulerian(graph)) {
				printPath(s, graph);
				System.out.println();
			}
			else{
				System.out.println("Test case " + asdf + ": impossible");
			}
		}
	}
	public boolean isEulerian(boolean[][] graph){
		for(int i = 0;i < graph.length;i++){
			int degree = 0;
			for (int j = 0; j < graph[i].length; j++) {
				if(graph[i][j]) degree++;
			}
			if(degree % 2 != 0) return false;
		}
		return true;
	}
	public int verticesCount(int v, boolean[][] graph){
		boolean[] visited = new	boolean[graph.length];
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		while(!q.isEmpty()){
			int cur = q.remove();
			if(visited[cur]) continue;
			visited[cur] = true;
			for (int i = 0; i < graph.length; i++) {
				if(graph[cur][i]){
					q.offer(i);
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]) cnt++;
		}
		return cnt;
	}
	public void printPath(int cur, boolean[][] graph){
		for (int i = 0; i < graph[cur].length; i++) {
			if(graph[cur][i]){
					graph[cur][i] = graph[i][cur] = false;
					System.out.print(al.get(cur)+"<->" + al.get(i)+" ");
					printPath(i, graph);

			}
		}
	}
	public boolean isBridge(int u, int  v, boolean[][] graph){
		int a = verticesCount(u, graph);
		graph[u][v] = graph[v][u] = false;
		int b = verticesCount(u, graph);
		graph[u][v] = graph[v][u] = true;
		return a > b;
	}
}
