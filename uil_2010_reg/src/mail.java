import java.util.*;
import java.io.*;
public class mail{
	Map<Integer,List<Integer>> m;
	int max;
	public static void main(String[] args)throws Exception{
		new mail().run();
	}
	public void run()throws Exception{
		Scanner f = new Scanner(new File("mail.dat"));
		// Scanner f = new Scanner(in);
		int times = f.nextInt();
		while(times-->0){
			m = new HashMap<>();
			int mail = f.nextInt(), maxOpen = Integer.MIN_VALUE;
			for (int i = 0; i < mail; i++) {
				int c = f.nextInt();
				m.put(i,new ArrayList<>());
				for (int j = 0; j < c; j++) {
					m.get(i).add(f.nextInt()-1);
				}
			}
			for(Integer mm : m.keySet()){
				max = Integer.MIN_VALUE;
				HashSet<Integer> hs = new HashSet<>();
				recur(mm,hs);
				maxOpen = Math.max(max,maxOpen);
			}
			System.out.println(maxOpen);
		}
	}
	public void recur(int cur, HashSet<Integer> visited){
		if(!visited.contains(cur)){
			visited.add(cur);
			max = Math.max(visited.size(),max);
			if(m.get(cur)==null || m.get(cur).isEmpty()){
				return;
			}
			for(Integer neighbor : m.get(cur)){
				recur(neighbor,visited);
			}
			visited.remove(cur);
		}
	}
}
