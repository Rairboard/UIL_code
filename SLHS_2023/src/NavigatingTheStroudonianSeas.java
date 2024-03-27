import java.util.*;
import java.io.*;

public class NavigatingTheStroudonianSeas {
	static Map<Integer,List<Integer>> m;
    static Map<Integer,Set<Integer>> path;
    public static void main(String[] args) throws Exception {
        new NavigatingTheStroudonianSeas().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("NavigatingTheStroudonianSeas.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
            m = new HashMap<>();
            int port =f.nextInt(), route = f.nextInt(), A = f.nextInt(), B = f.nextInt();
            for (int i = 1; i <= port; i++) {
                m.put(i,new ArrayList<>());
            }
            for (int i = 0; i < route; i++) {
                int a = f.nextInt(), b =f.nextInt();
                m.get(a).add(b);
                m.get(b).add(a);
            }
            path = new HashMap<>();
            Map<Integer,Set<Integer>> agnus = new HashMap<>();
//            recur()
        }
        f.close();
    }
    public void recur(int cur, int end, Set<Integer> visit, int time){
        visit.add(cur);
        path.putIfAbsent(cur,new LinkedHashSet<>());
        path.get(cur).add(time);
            for(Integer neighbor: m.get(cur)){
                if(!visit.contains(neighbor)){
                    recur(neighbor,end,visit,time+1);
                }
            }
    }
}
