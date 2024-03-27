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
        while (times-- > 0) {
			int n = f.nextInt();
			f.nextLine();
			double[][] conversion = new double[n][n];
			boolean[][] v = new boolean[n][n];
			List<String> cur = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				cur.add(f.nextLine());
			}
			int N = f.nextInt();
			f.nextLine();
			for (int i = 0; i < N; i++) {
				String one = f.next(), two = f.next();
				double val = f.nextDouble();
				f.nextLine();
				int a = cur.indexOf(one);
				int b = cur.indexOf(two);
				conversion[a][b] = val;
				conversion[b][a] = 1/val;
				v[a][b] = v[b][a] = true;
			}
			boolean found = false;
			int s = cur.indexOf(f.next()), e = cur.indexOf(f.next());
			if(f.hasNext()){
				f.nextLine();
			}
			Queue<Double> q = new LinkedList<>();
			boolean[] visit = new boolean[n];
			q.offer((double)s);
			q.offer(1.0);
			if(e<0 || e>=n || s < 0 || s>= n){
				out.println("NO CONVERSION RATE AVAILABLE");
				continue;
			}
			while(!q.isEmpty()){
				double point = q.remove();
				double value = q.remove();
				int current= (int)point;
				if(v[current][e]){
					found = true;
					out.printf("%.2f\n",value * conversion[current][e]);
					break;
				}
				if(visit[current]) continue;
				visit[current] = true;
				for (int i = 0; i < n; i++) {
					if(v[current][i]){
						q.offer((double)i);
						q.offer(value * conversion[current][i]);
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
