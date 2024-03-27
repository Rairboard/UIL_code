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

public class findut {
	boolean[][] v;
	long[][] cost;
	List<Integer> path;
    public static void main(String[] args) throws Exception {
        new findut().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("findut").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		Map<Integer,List<String>> m = new LinkedHashMap<>();
		int cur = 1;
		while(f.hasNext()){
			String ln = f.nextLine();
			if (ln.matches("DATASET.*")) {
				cur = Integer.parseInt(ln.split("\\s+")[1]);
				m.put(cur,new ArrayList<>());
			}
			else{
				m.get(cur).add(ln);
			}
		}
		for(Integer ds : m.keySet()){
			out.println("DATASET " + ds);
			List<String> input = new ArrayList<>(m.get(ds));
			String[] ln = input.getFirst().split("\\s+");
			List<String> al = new ArrayList<>();
			v = new boolean[Integer.parseInt(ln[0])][Integer.parseInt(ln[0])];
			cost = new long[Integer.parseInt(ln[0])][Integer.parseInt(ln[0])];
			path = new ArrayList<>();
			for (int i = 1; i < ln.length; i++) {
				al.add(ln[i]);
			}
			for (int i = 1; i < input.size(); i++) {
				String[] ll = input.get(i).split("\\s+");
				int a = al.indexOf(ll[0]), b = al.indexOf(ll[1]), c = Integer.parseInt(ll[2]);
				v[a][b] = v[b][a] = true;
				cost[a][b] = cost[b][a] = c;
			}
			long[] shadow = new long[al.size()];
			Arrays.fill(shadow,Integer.MAX_VALUE);
			List<Integer> w = new ArrayList<>();
			recur(0,1,shadow,0,w);
			path.add(1);
			for (int i = 0; i < path.size(); i++) {
				out.print(al.get(path.get(i))+" ");
			}
			out.println(shadow[1]);
		}
        f.close();
    }
	public void recur(int cur, int goal, long[] shad,long dis,List<Integer> w){
		if(dis>=shad[cur]) return;
		shad[cur] = dis;
		if(cur==goal){
			path = new ArrayList<>(w);
			return;
		}
		w.add(cur);
		for (int i = 0; i < v[cur].length; i++) {
			if(v[cur][i]){
				recur(i,goal,shad,dis+cost[cur][i],w);
			}
		}
		w.remove((Integer)cur);
	}
}
