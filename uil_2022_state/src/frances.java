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

public class frances {
    public static void main(String[] args) throws Exception {
        new frances().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("frances").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			List<String> course = new ArrayList<>(List.of(f.nextLine().trim().split(",")));
			String[] edges = f.nextLine().trim().split(",");
			int n = course.size();
			boolean[][] connected = new boolean[n][n];
			boolean[] visited = new boolean[n];
			int[] indegree = new int[n];
			int[] timeTaken = new int[n];
			for (int i = 0; i < edges.length; i++) {
				String[] edge = edges[i].split("->");
				int a = course.indexOf(edge[0]);
				int b = course.indexOf(edge[1]);
				connected[a][b] = true;
				indegree[b]++;
			}
			String[] order = f.nextLine().trim().split(",");
			f.nextLine();
			boolean good = true;
			for (int i = 0; i < order.length; i++) {
				int v = course.indexOf(order[i]);
				if(v==-1|| indegree[v]!=0){
					good = false;
				}
				timeTaken[v]++;
				visited[v]=true;
				for (int j = 0; j < n; j++) {
					if(connected[v][j]){
						indegree[j]--;
					}
				}
			}
			if(good){
				for (int i = 0; i < n; i++) {
					if(!visited[i] || timeTaken[i]>1) {
						good = false;
						break;
					}
				}
				if(good) out.println("Degree plan #" + asdf + " is legal.");
				else out.println("Degree plan #" + asdf + " is illegal.");
			}
			else{
				out.println("Degree plan #" + asdf + " is illegal.");
			}
        }
        f.close();
    }
}
