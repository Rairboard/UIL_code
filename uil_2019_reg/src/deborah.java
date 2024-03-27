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

public class deborah {
	Map<String,List<String>> m;
    public static void main(String[] args) throws Exception {
        new deborah().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("deborah").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt(), d = -1;
			f.nextLine();
			m = new HashMap<>();
			List<String> fav = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String file = f.next();
				int ff = f.nextInt();
				int child = f.nextInt();
				if(child==0){
					f.nextLine();
					f.nextLine();
				}
				else{
					for (int j = 0; j < child; j++) {
						String s = f.next();
						m.putIfAbsent(file,new ArrayList<>());
						m.get(file).add(s);
					}
				}
				if(ff==1){
					fav.add(file);
				}
			}
			Map<Integer,List<String>> tm = new TreeMap<>(Collections.reverseOrder());
			for (int i = 0; i < fav.size(); i++) {
				int maxDepth = -1;
				Set<String> visited = new HashSet<>();
				for(String file : m.keySet()){
					maxDepth = Math.max(maxDepth,recur(file,fav.get(i),0,visited));
				}
				if(maxDepth!=-1){
					tm.putIfAbsent(maxDepth,new ArrayList<>());
					tm.get(maxDepth).add(fav.get(i));
				}
				d = Math.max(d,maxDepth);
			}
			Collections.sort(tm.get(d));
			out.println(tm.get(d).get(0) + " (" + d + ")");
        }
        f.close();
    }
	public int recur(String cur, String goal, int depth,Set<String> visited){
		if(!visited.contains(cur)){
			if (cur.equals(goal)) {
				return depth;
			}
			if(m.get(cur)==null) return -1;
			visited.add(cur);
			int max = -1;
			for(String child : m.get(cur)){
				max = Math.max(max,recur(child,goal,depth+1,visited));
			}
			visited.remove(cur);
			return max;
		}
		return -1;
	}
}
