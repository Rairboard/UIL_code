import java.util.*;
import java.io.*;
import java.io.File;
import static java.lang.System.*;


public class SpaceBaseRescue {
    public static void main(String[] args) throws Exception {
        new SpaceBaseRescue().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("SpaceBaseRescue").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int n = f.nextInt(),  m = f.nextInt();
		f.nextLine();
		long[] peep = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
		boolean[][] v = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			int a = f.nextInt()-1, b = f.nextInt()-1;
			v[a][b] = true;
		}
		int s = f.nextInt();
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		while(!q.isEmpty()){
			int cur = q.remove();
			if(visited[cur]) continue;
			visited[cur] = true;
			for (int i = 0; i < n; i++) {
				if(i!=cur&&v[cur][i]){
					q.offer(i);
				}
			}
		}
		long room = 0;
		long total = 0;
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]){
				room++;
				total+=peep[i];
			}
		}
		out.println(total+"\n" + room);
        f.close();
    }
}
