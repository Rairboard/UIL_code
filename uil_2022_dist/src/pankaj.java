import java.util.*;
import java.io.*;

public class pankaj {
    public static void main(String[] args) throws Exception {
        new pankaj().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File("pankaj.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            List<String> al = new ArrayList<>(List.of(f.nextLine().trim().split(",")));
            String[] edges = f.nextLine().trim().split(",");
            int n = al.size();
            boolean[][] connected = new boolean[n][n];
            int[] color = new int[n];
            Arrays.fill(color, -1);
            for (int i = 0; i < edges.length; i++) {
                String[] edge = edges[i].split("<->");
                int u = al.indexOf(edge[0]);
                int v = al.indexOf(edge[1]);
                connected[u][v] = connected[v][u] = true;
            }
            boolean isBipartite = true;
            out: for (int i = 0; i < n; i++) {
                if(color[i]==-1){
                    color[i] = 0;
                    Queue<Integer> q = new LinkedList<>();
                    q.offer(i);
                    while (!q.isEmpty()) {
                        int u = q.remove();
                        for (int v = 0; v < n; v++) {
                            if(connected[u][v]){
                                if(color[v] == -1){
                                    color[v] = 1 ^ color[u];
                                    q.offer(v);
                                }
                                else if(color[v] == color[u]){
                                    isBipartite = false;
                                    break out;
                                }
                            }
                        }
                    }
                }
            }
            if(isBipartite){
                System.out.println("Test case " +asdf + ": possible");
            }
            else{
                System.out.println("Test case " + asdf + ": impossible");
            }
        }
        f.close();
    }
//    public void run() throws Exception {
//        Scanner f = new Scanner(new File("pankaj.dat"));
//        //Scanner f = new Scanner(System.in);
//        int times = f.nextInt();
//        f.nextLine();
//        for (int asdf = 1; asdf <= times; asdf++) {
//            List<String> al = new ArrayList<>(List.of(f.nextLine().trim().split(",")));
//            String[] edges = f.nextLine().trim().split(",");
//            int n = al.size();
//            boolean[][] connected = new boolean[n][n];
//            int[] color = new int[n];
//            Arrays.fill(color, -1);
//            for (int i = 0; i < edges.length; i++) {
//                String[] edge = edges[i].split("<->");
//                int u = al.indexOf(edge[0]);
//                int v = al.indexOf(edge[1]);
//                connected[u][v] = connected[v][u] = true;
//            }
//            boolean isBipartite = recur(2, 0, n, connected, color);
//            System.out.print("Test case " + asdf + ": ");
//            if(isBipartite) System.out.println("possible");
//            else System.out.println("impossible");
//        }
//        f.close();
//    }
//    public boolean recur(int m, int cur, int n, boolean[][] connected, int[] color){
//        if(cur==n) return true;
//        for (int c = 0; c < m; c++) {
//            boolean canColor = true;
//            for (int i = 0; i < n; i++) {
//                if(connected[cur][i] && color[i]==c){
//                    canColor = false;
//                    break;
//                }
//            }
//            if(canColor){
//                color[cur] = c;
//                if (recur(m, cur + 1, n, connected, color)) {
//                    return true;
//                }
//                color[cur] = -1;
//            }
//        }
//        return false;
//    }

}
