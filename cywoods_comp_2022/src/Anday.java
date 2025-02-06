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
            int n  =f.nextInt();
            int[][] point =new int[n][2];
            for (int i = 0; i < n; i++) {
                point[i] = new int[]{f.nextInt(),f.nextInt()};
            }
            PriorityQueue<Road> pq =new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    pq.add(new Road(i,j,distance(point[i],point[j])));
                }
            }
            int[] parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            n--;
            long total = 0;
            while(n > 0){
                Road r = pq.remove();
                int head1 = find(parent, r.a);
                int head2 = find(parent, r.b);
                if(head1 != head2){
                    union(parent, head1, head2);
                    total += r.distance;
                    n--;
                }
            }
            System.out.println(total);
        }
        f.close();
    }
    public void union(int[] parent, int head1, int head2){
        parent[head1] = parent[head2];
    }
    public int find(int[] parent, int i){
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }
    public long distance(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    class Road implements Comparable<Road>{
        int a, b;
        long distance;
        public Road(int i, int j, long d){
            a = i;
            b = j;
            distance = d;
        }
        public int compareTo(Road o){
            return Long.compare(distance,o.distance);
        }
    }
}
