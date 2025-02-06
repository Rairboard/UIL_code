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

public class star {
    public static void main(String[] args) throws Exception {
        new star().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("star").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		int p = f.nextInt(), n = f.nextInt(), cases = f.nextInt();
		f.nextLine();
		List<String> al = new ArrayList<>();
		double[][] m = new double[p][3];
		for (int i = 0; i < p; i++) {
			al.add(f.next());
			m[i] = new double[]{f.nextDouble(), f.nextDouble(), f.nextDouble()};
		}
		boolean[][] con = new boolean[p][p];
		for (int i = 0; i < n; i++) {
			int a = al.indexOf(f.next());
			int b = al.indexOf(f.next());
			con[a][b] = con[b][a] = true;
		}
		for (int i = 0; i < cases; i++) {
			int a = al.indexOf(f.next());
			int b = al.indexOf(f.next());
			double[] shadow =new double[p];
			Arrays.fill(shadow,Double.MAX_VALUE);
			PriorityQueue<double[]> pq =new PriorityQueue<>((one,two) -> Double.compare(one[1],two[1]));
			pq.add(new double[]{a,0});
			while(!pq.isEmpty()){
				double[]ar = pq.remove();
				int cur = (int)ar[0];
				double dis = ar[1];
				if(dis>=shadow[cur]) continue;
				shadow[cur] = dis;
				for (int j = 0; j < p; j++) {
					if(cur!=j&&con[cur][j]){
						pq.offer(new double[]{j, calculate(cur,j,m) + dis});
					}
				}
			}
			if(shadow[b] == Double.MAX_VALUE) out.println("These are not the planets you're looking for.");
			else out.printf("%s -> %s : %,.3f\n", al.get(a), al.get(b), shadow[b]);
		}
        f.close();
    }
	public double calculate(int a, int b, double[][] m){
		return Math.sqrt(Math.pow(m[a][0] - m[b][0],2) + Math.pow(m[a][1] - m[b][1],2) + Math.pow(m[a][2] - m[b][2],2));
	}
}
