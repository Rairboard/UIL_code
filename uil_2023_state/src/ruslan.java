import java.util.*;
import java.io.*;
class ruslan{
    static Map<String, List<String>> hm;
	List<String> path;
	public static void main(String[] args) throws Exception{
		new ruslan().run();
	}
	public void run() throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("ruslan.dat"));
	   int N =f.nextInt();
	   while(N-->0){
	       hm = new HashMap<>();
	       while(f.hasNext()){
	           String a = f.next();
	           String b;
	           if(a.equals("=====")){
	               path = new ArrayList<>();
				   HashSet<String> visited = new HashSet<>();
				   dfs("Ruslan","You",visited,"");
				   System.out.println(path.size());
				   break;
	           }
	           else{
	               b = f.next();
	               hm.putIfAbsent(a, new ArrayList());
	               hm.putIfAbsent(b, new ArrayList());
	               hm.get(a).add(b);
	               hm.get(b).add(a);
	           }
	       }
	   }
	}
    public void dfs(String current,String goal, Set<String> visited,String s) {
		if(!visited.contains(current)){
			if (current.equals(goal)) {
				if (!path.contains(s)) {
					path.add(s);
				}
				return;
			}
			visited.add(current);
			for (String neighbor : hm.get(current)) {
				dfs(neighbor, goal,visited,s+neighbor);
			}
			visited.remove(current);
		}
    }
}
