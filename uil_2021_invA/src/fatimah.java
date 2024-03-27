import java.util.*;
import java.io.*;
public class fatimah{
	public static void main(String[] args)throws Exception{
		new fatimah().run();
	}
	public void run()throws Exception{
	   // Scanner f =new Scanner(System.in);
	   Scanner f =new Scanner(new File("fatimah.dat"));
	   int N = f.nextInt();
	   for(int time = 1; time<=N;time++){
	       Map<String,List<String>> hm = new LinkedHashMap<>();
	       List<String> al = new ArrayList<>();
	       int n=f.nextInt(), m= f.nextInt();
	       for(int i=0;i<n;i++){
	           String a = f.next();
	           hm.put(a,new ArrayList());
	           al.add(a);
	       }
	       for(int i=0;i<m;i++){
	           String a =f.next(), b =f.next();
	           hm.get(a).add(b);
	           hm.get(b).add(a);
	       }
	       List<String> cur = new ArrayList<>(), max = new ArrayList<>();
	       dfs(hm, cur, max);
	       System.out.println("Case #" + time + ": " + max.size());
	   }
	}
	public void dfs(Map<String, List<String>> hm, List<String> current, List<String> max){
	    if(max.equals(new ArrayList<>(hm.keySet()))){
	        return;
	    }
	    for(String monster:hm.keySet()){
	        boolean join = true;
	        for(String cur_monster: current){
	            if(hm.get(cur_monster).contains(monster) || current.contains(monster)){
	                join = false;
	                break;
	            }
	        }
	        if(join){
	            current.add(monster);
	            dfs(hm, current, max);
	            current.remove(monster);
	        }
	    }
	    if(current.size()>max.size()){
	        max.clear();
	        max.addAll(current);
	    }
	}
}
