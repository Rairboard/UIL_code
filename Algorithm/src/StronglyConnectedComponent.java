import java.util.*;
import java.io.*;
public class StronglyConnectedComponent {
    int scc;
    long time;
    boolean[][] connected;
    long[] id;
    long[] ll;
    Stack<Integer> visited;
	public static void main(String[] args)throws Exception {
//        String a = new String("intern?");
//        System.out.println(a == "intern? ");
//        System.out.println(a.intern() == "intern? ");
//        System.out.println(a == "intern?");
		new StronglyConnectedComponent().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("StronglyConnectedComponent.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            scc = 0;
            time = 0;
            int n = f.nextInt();
            int m = f.nextInt();
            f.nextLine();
             connected = new boolean[n][n];
            for (int i = 0; i < m; i++) {
                int u = f.nextInt(), v = f.nextInt();
                connected[u][v] = true;
            }
            ll = new long[n];
            id = new long[n];
            visited = new Stack<>();
            Arrays.fill(ll, -1);
            Arrays.fill(id, -1);
            for (int i = 0; i < n; i++) {
                if(id[i]==-1){
                    recur(i);
                }
            }
            Map<Long,List<Integer>> component = new HashMap<>();
            for (int i = 0; i < n; i++) {
                component.putIfAbsent(ll[i], new ArrayList<>());
                component.get(ll[i]).add(i);
            }
            System.out.println(scc + " components");
            for(long lowlink : component.keySet()){
                System.out.println(component.get(lowlink));
            }
            System.out.println();
        }
        f.close();
	}
    public void recur(int u){
        id[u] = ll[u] = time++;
        visited.push(u);
        for (int v = 0; v < id.length; v++) {
            if(connected[u][v]){
                if(id[v]==-1) recur(v);
                else ll[u] = Math.min(ll[u], ll[v]);
            }
        }
        if(ll[u] == id[u]){
            while(visited.peek() != u){
                int node = visited.pop();
                ll[u] = Math.min(ll[u], ll[node]);
            }
            scc++;
        }
    }
}
