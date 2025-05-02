import java.util.*;
import java.io.*;
public class dots {
	public static void main(String[] args)throws Exception {
		new dots().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("dots.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int d = f.nextInt();
            f.nextLine();
            double[][] point = new double[d][2];
            for (int i = 0; i < d; i++) {
                point[i] = new double[]{f.nextDouble(), f.nextDouble()};
            }
            double suggest = 0;
            for(int i = 1;i<d;i++){
                suggest+=Math.sqrt(Math.pow(point[i][0] - point[i-1][0], 2) + Math.pow(point[i][1] - point[i-1][1],2));
            }
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < d; i++) {
                for(int j = i+1;j<d;j++){
                    double dis = Math.sqrt(Math.pow(point[i][0] - point[j][0], 2) + Math.pow(point[i][1] - point[j][1],2));
                    pq.add(new Edge(i,j,dis));
                }
            }
            int[] parent = new int[d];
            Arrays.fill(parent, -1);
            d--;
            double total = 0;
            while(d>0){
                Edge e = pq.remove();
                if (union(parent, e.u, e.v)) {
                    total+=e.w;
                    d--;
                }
            }
            System.out.printf("%.10f\n", suggest - total);
        }
        f.close();
	}
    public int find(int[] parent, int i){
        if(parent[i] < 0) return i;
        return parent[i] = find(parent, parent[i]);
    }
    public boolean union(int[] parent, int a, int b){
        int ahead = find(parent, a);
        int bhead = find(parent, b);
        if(ahead==bhead) return false;
        parent[ahead] += parent[bhead];
        parent[bhead] = ahead;
        return true;
    }
    class Edge implements Comparable<Edge>{
        int u , v;
        double w;
        public Edge(int u, int v, double w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int compareTo(Edge o){
            return Double.compare(w, o.w);
        }
    }
}
