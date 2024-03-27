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

public class TreeLabels {
	boolean found;
	boolean[][] v;
    public static void main(String[] args) throws Exception {
        new TreeLabels().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("TreeLabels").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			int n = f.nextInt();
			int[] label = new int[n];
			v = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				label[i] = f.nextInt();
			}
			for (int i = 0; i < n - 1; i++) {
				int a = f.nextInt()-1, b = f.nextInt()-1;
				v[a][b] = v[b][a] = true;
			}
			for (int i = 0; i < n; i++) {
				found = false;
				Set<Integer> visited = new HashSet<>();
				Set<Integer> dt = new HashSet<>();
				recur(0,i,visited);
				for(Integer in : visited){
					dt.add(label[in]);
				}
				out.println(dt.size());
			}
		}
        f.close();
    }
	public boolean recur(int cur, int end, Set<Integer> visited){
		if(found) return true;
		if (!visited.contains(cur)) {
			visited.add(cur);
			if(cur==end){
				found = true;
				return true;
			}
			for (int i = 0; i < v[cur].length; i++) {
				if(v[cur][i]){
					if(recur(i,end,visited)){
						return true;
					}
				}
			}
			visited.remove(cur);
		}
		return false;
	}
}
