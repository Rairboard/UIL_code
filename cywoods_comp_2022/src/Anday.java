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
        for (int asdf = 0; asdf < times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            int[][] point = new int[n][2];
            for (int i = 0; i < n; i++) {
                point[i] = new int[]{f.nextInt(),f.nextInt()};
            }
            int[] parent = new int[n];
            Arrays.fill(parent, -1);
            PriorityQueue<Road> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    long distance = Math.abs(point[i][0] - point[j][0]) + Math.abs(point[i][1] - point[j][1]);
                    pq.offer(new Road(i,j,distance));
                }
            }
            n--;
            long total = 0;
            while(n>0){
                Road r = pq.remove();
                int ahead = find(parent, r.a);
                int bhead = find(parent, r.b);
                if(ahead!=bhead){
                    n--;
                    total+=r.distance;
                    union(parent, ahead, bhead);
                }
            }
            System.out.println(total);
        }
        f.close();
    }
    public int find(int[] parent, int i){
        if(parent[i] == -1){
            return i;
        }
        return find(parent, parent[i]);
    }
    public void union(int[] parent, int ahead, int bhead){
        parent[ahead] = bhead;
    }
    class Road implements Comparable<Road> {
        int a, b;
        long distance;
        public Road(int a, int b, long distance){
            this.a = a;
            this.b = b;
            this.distance = distance;
        }
        public int compareTo(Road o){
            return Double.compare(distance, o.distance);
        }
    }
}
