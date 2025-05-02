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

public class valery {
	/* this problem is the most lexicographical topological sort
		so we can solve this by maintaining the indegree of each vertex
		and decrease them every visit (cut of all outgoing edges of current vertex)

		we start at a vertex that has indegree of zero but picket the most lexicographically
		smallest
	 */
    public static void main(String[] args) throws Exception {
		Stack<Integer> st = new Stack<>();

		List<? super Collections> al = new ArrayList<>();

//        new valery().run();
    }
	
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("valery").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		int n = f.nextInt();
		Map<String,Vertex> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String s = f.next();
			int M = f.nextInt();
			Vertex u = new Vertex(s);
			for (int j = 0; j < M; j++) {
				String v = f.next();
				u.edges.add(v);
			}
			m.put(s, u);
		}
		for(String u : m.keySet()){
			for(String v : m.get(u).edges){
				if(m.get(v)==null){
					Vertex vertex = new Vertex(v);
					m.put(v,vertex);
				}
				m.get(v).indegree++;
			}
		}
//		out.println(m);
		String ans = "";
		while(!m.isEmpty()){
			String nextVertex = "";
			for(String u : m.keySet()){
				if(m.get(u).indegree==0){
					if(nextVertex.isEmpty()){
						nextVertex = u;
					}
					else if(u.compareTo(nextVertex)<0){
						nextVertex = u;
					}
				}
			}
			Vertex u = m.remove(nextVertex);
			for(String v : u.edges){
				if(m.get(v)!=null) m.get(v).indegree--;
			}
			ans+= nextVertex+"->";
		}
		out.println(ans.substring(0, ans.lastIndexOf("->")));
        f.close();
    }
	class Vertex{
		int indegree;
		String v;
		HashSet<String> edges;
		public Vertex(String v){
			this.v = v;
			edges = new HashSet<>();
			indegree = 0;
		}
		public String toString(){
			return v + " " + indegree;
		}
	}
}
