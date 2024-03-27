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
		int p = f.nextInt(), con = f.nextInt(), N = f.nextInt();
		f.nextLine();
        List<String> planet = new ArrayList<>();
		Point[] cor = new Point[p];
		boolean[][] v = new boolean[p][p];
		for (int i = 0; i < p; i++) {
			planet.add(f.next());
			cor[i] = new Point(f.nextDouble(),f.nextDouble(),f.nextDouble());
			f.nextLine();
		}
		for (int i = 0; i < con; i++) {
			int a = planet.indexOf(f.next()), b = planet.indexOf(f.next());
			f.nextLine();
			v[a][b] = v[b][a] = true;
		}
		for (int i = 0; i < N; i++) {
			String a = f.next(), b = f.next();
			int s = planet.indexOf(a);
			int e = planet.indexOf(b);
			if(s==e){
				out.printf("%s -> %s : %,.3f\n",a,b,0.0);
			}
			else{
				Queue<Double> q = new LinkedList<>();
				q.add((double)s);
				q.add(0.0);
				double[] shadow = new double[p];
				Arrays.fill(shadow,Double.MAX_VALUE);
				while(!q.isEmpty()){
					double point = q.remove();
					double dis = q.remove();
					int cur = (int)point;
					if(dis>=shadow[cur]){
						continue;
					}
					shadow[cur] = dis;
					for (int j = 0; j < p; j++) {
						if(v[cur][j]){
							q.offer((double)j);
							q.offer(dis + cor[cur].getDistance(cor[j]));
						}
					}
				}
				if(shadow[e] == Double.MAX_VALUE){
					out.println("These are not the planets you're looking for.");
				}
				else{
					out.printf("%s -> %s : %,.3f\n",a,b,shadow[e]);
				}
			}
		}
        f.close();
    }
	class Point{
		double x,y,z;
		public Point(double a, double b, double c){
			x = a;
			y = b;
			z = c;
		}
		public double getDistance(Point o){
			return Math.sqrt(Math.pow(x-o.x,2) + Math.pow(y-o.y,2) + Math.pow(z-o.z,2));
		}
	}
}
