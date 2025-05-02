import java.util.*;
import java.io.*;
public class sergio {
    boolean cycle;
    Map<Integer,List<Integer>> m;
	public static void main(String[] args)throws Exception {
		new sergio().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("sergio.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int v = f.nextInt();
            int e = f.nextInt();
             m= new HashMap<>();
            for (int i = 0; i < e; i++) {
                int a = f.nextInt(), b = f.nextInt();
                m.putIfAbsent(a, new ArrayList<>());
                m.get(a).add(b);
            }
            cycle = false;
            for(int i = 0;i < v;i++){
                if(cycle) break;
                recur(i, new HashSet<>());
            }
            if(cycle) System.out.println("Cycle");
            else System.out.println("No cycle");
        }
        f.close();
	}
    public void recur(int cur, HashSet<Integer> visited){
        if(cycle) return;
        if(visited.contains(cur)){
            cycle = true;
            return;
        }
        if(m.get(cur)==null) return;
        visited.add(cur);
        for(int v : m.get(cur)){
            recur(v, visited);
        }
        visited.remove(cur);
    }
}
