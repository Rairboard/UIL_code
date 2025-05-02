import java.util.*;
import java.io.*;
public class Prob18 {
    Map<String,Integer> m;
	public static void main(String[] args)throws Exception {
		new Prob18().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob18.in.txt"));
        String[] nodeId = {"01","12","02","23","03","34","04"};
        m = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            m.put(nodeId[i],i+1);
            m.put(new StringBuilder(nodeId[i]).reverse().toString(),i+1);
        }
        int times = f.nextInt();
        f.nextLine();
        for (int adsf = 0; adsf < times; adsf++) {
            String bestPath = "";
            long min = Long.MAX_VALUE;
            long[] time = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            long[][] cost =new long[5][5];
            long[][] shadow = new long[5][1 << 5];
            for (int i = 0; i < shadow.length; i++) {
                Arrays.fill(shadow[i],Long.MAX_VALUE);
            }
            for (int i = 0; i < time.length; i++) {
                int a = Integer.parseInt(nodeId[i].substring(0,1));
                int b = Integer.parseInt(nodeId[i].substring(1));
                cost[a][b] = cost[b][a] = time[i];
            }
//            System.out.println(Arrays.toString(time) +"\n"+m);
//            for (int i = 0; i < cost.length; i++) {
//                System.out.println(Arrays.toString(cost[i]));
//            }
            Queue<state> q = new LinkedList<>();
            q.offer(new state(0,1, 0,""));
            while (!q.isEmpty()){
                state cur = q.remove();
                if(cur.t > shadow[cur.v][cur.visited]) continue;
//                System.out.println(cur.path);
//                System.out.println(Integer.toBinaryString(cur.visited));
                if(cur.visited == (1 << 5) - 1){
                    if(cur.t < min){
                        min =cur.t;
                        bestPath = cur.path.trim();
                    } else if (cur.t == min && cur.path.trim().compareTo(bestPath) < 0) {
                        bestPath = cur.path.trim();
                    }
                    continue;
                }
                shadow[cur.v][cur.visited] = cur.t;
                for(int i = 0;i < 5;i++){
                    if(cost[cur.v][i]>0){
                        q.offer(new state(i ,cur.visited | (1 << i), cur. t + cost[cur.v][i], cur.path + m.get(""+cur.v+i)+" "));
                    }
                }
            }
            System.out.println(bestPath);
        }
	}
    class state {
        int v;
        int visited;
        long t;
        String path;
        public state(int v,int visited, long t, String path){
            this.v = v;
            this.visited = visited;
            this.t = t;
            this.path = path;
        }
    }
}
