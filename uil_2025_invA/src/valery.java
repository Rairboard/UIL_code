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

    public static void main(String[] args) throws Exception {
        new valery().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("valery").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int v = f.nextInt();
		f.nextLine();
		Map<String,Vertex> m = new HashMap<>();
		for (int i = 0; i < v; i++) {
			String node = f.next();
			int n = f.nextInt();
			Vertex vertex = new Vertex(node);
			for (int j = 0; j < n; j++) {
				String neighbor = f.next();
				vertex.edges.add(neighbor);
			}
			m.put(node, vertex);
		}
		for(String node : m.keySet()){
			for(String neighbor : m.get(node).edges){
				if(m.get(neighbor)!=null) m.get(neighbor).indegree++;
			}
		}
		String ans = "";
		while(!m.isEmpty()){
			String s = "";
			for(String node : m.keySet()){
				if(s.isEmpty()){
					s = m.get(node).name;
				}
				else if(m.get(node).indegree==0 && m.get(node).name.compareTo(s) < 0){
					s = m.get(node).name;
				}
			}
			Vertex removed = m.remove(s);
			for(String node : removed.edges){
				if(m.get(node)!=null) m.get(node).indegree--;
			}
			ans += s + "->";
		}
		out.println(ans.substring(0,ans.lastIndexOf("->")));
        f.close();
    }
	class Vertex {
		String name;
		Set<String> edges;
		int indegree;
		public Vertex(String name){
			this.name = name;
			edges = new HashSet<>();
			indegree = 0;
		}
	}
}
