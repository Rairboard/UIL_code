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

public class hacks {
	Map<String,List<Edge>> m;
	Map<String,Set<String>> owner;
    public static void main(String[] args) throws Exception {
        new hacks().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hacks").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0){
			int v = f.nextInt();
			m = new HashMap<>();
			owner = new TreeMap<>();
			List<String> company = new ArrayList<>();
			for (int i = 0; i < v; i++) {
				String a = f.next();
				m.putIfAbsent(a,new ArrayList<Edge>());
				m.get(a).add(new Edge(f.next(),f.nextInt()));
				company.add(a);
			}
			for(String s : m.keySet()){
				out.println(s + ": " + m.get(s));
			}
			out.println();
			for(String s : company){
				owner.put(s,new TreeSet<>());
				HashSet<String> visited = new HashSet<>();
				dfs(s,s,visited,0);
			}
			for(String bigboss : owner.keySet()){
				if(owner.get(bigboss).size()>0){
					out.print(bigboss + ": ");
					for(String notbigboss : owner.get(bigboss)){
						out.print(notbigboss + " ");
					}
					out.println();
				}
			}
			out.println();
		}
	}
	public void dfs(String boss,String cur,HashSet<String> visited,int percent){
		if(!visited.contains(cur)){
			if(percent>=50){
				owner.get(boss).add(cur);
			}
			visited.add(cur);
			if(m.get(cur)==null) return;
			for(Edge e : m.get(cur)){
				if(percent + e.w >= 50){
					dfs(boss,e.c,visited,percent + e.w);
				}
			}
			visited.remove(cur);
		}
	}
	class Edge{
		String c;
		int w;
		public Edge(String company,int weight){
			c = company;
			w = weight;
		}
		public String toString(){
			return String.format("%s -> %d",c ,w);
		}

		public int compareTo(Edge o) {
			return o.w - w;
		}
	}
}
