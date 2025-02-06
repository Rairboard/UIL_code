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

public class currency {
    public static void main(String[] args) throws Exception {
        new currency().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("currency").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
		for (int asdf = 0; asdf < times; asdf++) {
			int n = f.nextInt();
			f.nextLine();
			List<String> al = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				al.add(f.nextLine());
			}
			int p = f.nextInt();
			f.nextLine();
			double[][] conversion = new double[n][n];
			boolean[][] con = new boolean[n][n];
			for (int i = 0; i < p; i++) {
				int a = al.indexOf(f.next());
				int b = al.indexOf(f.next());
				double c = f.nextDouble();
				con[a][b] = con[b][a] = true;
				if(c!=0){
					conversion[a][b] = c;
					conversion[b][a] = 1/c;
				}
			}
			int a = al.indexOf(f.next());
			int b = al.indexOf(f.next());
			PriorityQueue<double[]> pq =new PriorityQueue<>((one,two) -> Double.compare(one[1],two[1]));
			pq.add(new double[]{a,1});
			boolean found = false;
			boolean[] visited =new boolean[n];
			while(!pq.isEmpty()){
				double[] ar = pq.remove();
				int cur = (int)ar[0];
				double c = ar[1];
				if(cur==b){
					out.printf("%.2f\n", c);
					found = true;
					break;
				}
				if(visited[cur]) continue;
				visited[cur] = true;
				for (int i = 0; i < n; i++) {
					if(con[cur][i] && cur!=i){
						pq.offer(new double[]{i,c * conversion[cur][i]});
					}
				}
			}
			if(!found){
				out.println("NO CONVERSION RATE AVAILABLE");
			}
		}
        f.close();
    }
}
