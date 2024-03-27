import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class partay {
	Map<String,List<Edge>> m;
	Map<String,Integer> shadow;
	boolean solved;
	int min;
    public static void main(String[] args) throws Exception {
        new partay().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("partay").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			m = new HashMap<>();
			shadow = new HashMap<>();
			solved = false;
			String[] l = f.nextLine().split("\\s+");
			int N = f.nextInt();
			int highway = 0;
			min = Integer.MAX_VALUE;

			for (int i = 0; i < l.length; i++) {
				m.put(l[i],new ArrayList<>());
				shadow.put(l[i],Integer.MAX_VALUE);
			}

			for (int i = 0; i < N; i++) {
				String a = f.next(), b = f.next();
				int dis = f.nextInt();
				if(f.hasNext()){
					f.nextLine();
				}
				if (a.equals("A") && b.equals("P")) {
					highway = dis;
				}else{
					m.putIfAbsent(a,new ArrayList<>());
					m.putIfAbsent(b,new ArrayList<>());
					m.get(a).add(new Edge(b,dis));
					m.get(b).add(new Edge(a,dis));
				}
			}
			HashSet<String> visited = new HashSet<>();
			recur("A","P",visited,0);
			if(solved && min < highway){
				out.println(highway - min + " minutes saved");
			}else{
				out.println("Saturday");
			}
        }
        f.close();
    }
	public void recur(String cur, String goal, Set<String> visited,int time){
		if (cur.equals(goal)) {
			solved = true;
			min = Math.min(min,time);
		}
		else {
			visited.add(cur);
			shadow.put(cur,time);
			if(m.get(cur) == null) return;
			for(Edge neighbor : m.get(cur)){
				if (!visited.contains(neighbor.destiny) && time + neighbor.cost < shadow.get(neighbor.destiny)) {
					recur(neighbor.destiny,goal,visited,time + neighbor.cost);
				}
			}
			visited.remove(cur);
		}
	}
	class Edge{
		String destiny;
		int cost;
		public Edge(String d, int c){
			destiny = d;
			cost = c;
		}
	}
}
