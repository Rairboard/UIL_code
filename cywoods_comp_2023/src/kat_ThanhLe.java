import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class kat_ThanhLe {
	Map<String,Integer> shadow;
	Map<String,List<String>> m;
	boolean solved;
	int min;
    public static void main(String[] args) throws Exception {
        new kat_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Kat.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			m = new HashMap<>();
			shadow = new HashMap<>();
			int fr = f.nextInt(), c = f.nextInt();
			f.nextLine();
			for (int i = 0; i < fr; i++) {
				String a = f.next();
				String not = f.next();
				String b = f.next();
				if(!not.equals("NOT")){
					m.putIfAbsent(a,new ArrayList<>());
					m.putIfAbsent(b,new ArrayList<>());
					m.get(a).add(b);
					m.get(b).add(a);
				}
			}
			for (int i = 0; i < c; i++) {
				String[] people = new String[2];
				boolean[] yes = new boolean[2];
				int[] d = new int[2];
				for (int j = 0; j < 2; j++) {
					String s = f.next();
					Set<String> visited = new LinkedHashSet<>();
					min = Integer.MAX_VALUE;
					solved = false;
					for(String node : m.keySet()){
						shadow.put(node,Integer.MAX_VALUE);
					}
					recur("Kat",s,visited,0);
					yes[j] = solved;
					d[j] = min;
					people[j] = s;
				}
				if(yes[0]&&yes[1]){
					if(d[0]==d[1]){
						out.println(people[0].length() == people[1].length() ? people[0] : (people[0].length() < people[1].length() ? people[0] : people[1]));
					}
					else{
						out.println(d[0] < d[1] ? people[0]:people[1]);
					}
				}else if(yes[0] && !yes[1]){
					out.println(people[0]);
				}else if(!yes[0] && yes[1]){
					out.println(people[1]);
				}else{
					out.println("NO FRIENDS");
				}
			}
        }
        f.close();
    }
	public void recur(String cur, String goal, Set<String> visited,int step){
		if(!visited.contains(cur) && step < shadow.get(cur)){
			visited.add(cur);
			shadow.put(cur,step);
			if(cur.equals(goal)){
				visited.remove(cur);
				min = step;
				solved = true;
				return;
			}
			if(m.get(cur)==null) return;
			for(String friends : m.get(cur)){
				recur(friends,goal,visited,step+1);
			}
			visited.remove(cur);
		}
	}
}
