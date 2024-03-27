import java.util.*;
import java.io.*;

public class luann {
	static char[][] m;
    public static void main(String[] args) throws Exception {
        new luann().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("luann.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
			int N = f.nextInt(), hs = 0, vs = 0;
			List<Point> al = new ArrayList<>();
			for(int i=0;i<N;i++){
				int x = f.nextInt(), y = f.nextInt();
				al.add(new Point(y-1,x-1));
				hs = Math.max(hs,x);
				vs = Math.max(vs,y);
			}
			m = new char[vs][hs];
			for (int i = 0; i < m.length; i++) {
				Arrays.fill(m[i],' ');
			}
			for(Point p : al){
				m[p.r][p.c] = 'X';
			}
			for (int i = m.length-1; i >=0; i--) {
				System.out.println(i+1 + "|" + new String(m[i]));
			}
			System.out.print("  ");
			for (int i = 0; i < N; i++) {
				System.out.print("_");
			}
			System.out.print("\n  ");
			for (int i = 1; i <= N; i++) {
				System.out.print(i);
			}
			System.out.println("\n=====");
        }
        f.close();
    }
	class Point{
		int r,c;
		public Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
