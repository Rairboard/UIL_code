import java.util.*;
import java.io.File;

public class Anday {
    public static void main(String[] args) throws Exception {
        new Anday().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Anday").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int v = f.nextInt();
            Point[] loc = new Point[v];
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < v; i++) {
                loc[i] = new Point(f.nextInt(),f.nextInt(),i);
            }
            for (int i = 0; i < loc.length; i++) {
                for (int j = i + 1; j < loc.length; j++) {
                    pq.offer(new Edge(loc[i],loc[j],calculateDistance(loc[i],loc[j])));
                }
            }
            int[] parent = new int[v];
            for (int i = 0; i < v; i++) {
                parent[i] = i;
            }
            int total = 0;
            v--;
            while(v>0){
                Edge e = pq.poll();
                int head1 = find(parent,e.a.index);
                int head2 = find(parent,e.b.index);
                if(head1!=head2){
                    v--;
                    total+=e.weight;
                    union(parent,head1,head2);
                }
            }
            System.out.println(total);
        }
        f.close();
    }
    public int find(int[] parent,int i){
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent,parent[i]);
    }
    public void union(int[] parent,int a,int b){
        parent[a] = b;
    }
    public int calculateDistance(Point a,Point b){
        return Math.abs(b.x - a.x) + Math.abs(b.y - a.y);
    }
    class Point{
        int x,y,index;
        public Point(int x,int y,int index){
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }
    class Edge implements Comparable<Edge>{
        Point a,b;
        int weight;
        public Edge(Point a,Point b,int weight){
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }
    }
}
