import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class TopologicalSort {
    public static void main(String[] args) throws Exception {
        new TopologicalSort().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("TopologicalSort").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        // getting number of vertices and edges
		int n = f.nextInt();
		int M = f.nextInt();

		// counting in and out degree for each vertex
		int[] indegree = new int[n];
		int[] outdegree = new int[n];
		int[][] edges = new int[n][2];
		boolean[] visited = new boolean[n];
		Map<Integer,List<Integer>> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			m.put(i, new ArrayList<>());
		}

		// get the edges (directed)
		for (int i = 0; i < M; i++) {
			edges[i] = new int[]{f.nextInt(),f.nextInt()};
		}

		// increment indegree of the vertex that is pointed to by 1
		// increment outdegree of the vertex that is pointing by 1
		// update the graph -> edges are directed only
		for (int i = 0; i < M; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			indegree[b]++;
			outdegree[a]++;
			m.get(a).add(b);
		}
		/*
			the intuition behind topological sorting is that we would visit every vertex that have indegree of 0 (no edge directed toward it meaning
			not dependent of other vertex so can be process first)

			we to visit vertices in an order that a vertex can only be process when it isn't dependent on any other vertex being process before
			but because there could be multiple vertex with indegree of zero at a point during the traversal, we would use a queue to ensure that
			the vertex is the beforemost (or having indegree of zero the soonest)

			1. we start the BFS with any node that has indegree = 0
			2. then while the queue isn't empty (there are still vertex that have indegree of zero that haven't been process)
			3. for every vertex u we visit, we decrement the indegree of all vertex v that u pointed to, and we set visited[u] = true
			4. if v indegree = 0 after cutting of all of u outgoing edges (decrementing the indegree) we can add v to the queue (ensuring that all
			vertices that hit indegree = 0 before v will be process first
			5. we check if all vertices have been processes through the visited array, if yes, then there is possible route based on current
			dependencies, otherwise no.
		*/
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if(indegree[i]==0){
				if(outdegree[i]==0) {
					/* we need this check because if a vertex both has in and out degree of zero, that mean there are multiple components in the graph
					which mean that they don't have any dependencies so we can mark visited[i] = true
					 */
					visited[i] = true;
				}
				else q.offer(i);
			}
		}
		while(!q.isEmpty()){
			int cur = q.remove();
			visited[cur] = true;
			for(Integer v : m.get(cur)){
				indegree[v]--;
				if(indegree[v]==0) q.offer(v);
			}
		}

		boolean possible = true;
		for (int i = 0; i < n; i++) {
			if(!visited[i]) possible = false;
		}
		if(possible) out.println("yes");
		else out.println("no");
        f.close();
    }
}
