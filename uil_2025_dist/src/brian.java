import java.util.*;
import java.io.*;
public class brian {
	public static void main(String[] args)throws Exception {
		new brian().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("brian.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int n = f.nextInt(), m = f.nextInt();
            f.nextLine();
            List<String> al = new ArrayList<>();
            Map<String,Map<String,Long>> data = new HashMap<>();
            Map<String,Integer> index = new HashMap<>();
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                String[] ln = f.nextLine().trim().split("\\s+");
                String u = ln[0];
                String v = ln[1];
                long w = Long.parseLong(ln[2]);
                data.putIfAbsent(u, new HashMap<>());
                data.get(u).put(v, w);
                if (!index.containsKey(u)) {
                    index.put(u, cnt++);
                }
                if (!index.containsKey(v)) {
                    index.put(v,cnt++);
                }
            }
            int s = index.get(f.next());
            int e = index.get(f.next());
            long[] shadow = new long[n];
            Arrays.fill(shadow, (long)1e14);
            shadow[s] = 0;
            boolean negativeCycle = false;
            out : for (int i = 0; i < n; i++) {
                for(String a : data.keySet()){
                    for(String b : data.get(a).keySet()){
                        int u = index.get(a);
                        int v = index.get(b);
                        if(shadow[u] + data.get(a).get(b) < shadow[v]){
                            if(i==n-1){
                                negativeCycle = true;
                                break out;
                            }
                            shadow[v] = shadow[u] + data.get(a).get(b);
                        }
                    }
                }
            }
            if(negativeCycle) System.out.println("Take as long as you neeed.");
            else System.out.println(shadow[e]);
        }
        f.close();
	}
}
