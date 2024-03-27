import java.util.*;
import java.io.*;

public class dinesh {
    Map<String,List<String>> m;
    Map<String, Integer> cost;
    static int min;

    public static void main(String[] args) throws Exception {
        new dinesh().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("dinesh.dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            m = new HashMap<>();
            cost = new HashMap<>();
            String[] l = f.nextLine().split("\\s+");
            for (int i = 0; i < l.length; i++) {
                m.put(l[i],new ArrayList<>());
            }
            int N = f.nextInt();f.nextLine();
            for (int i = 0; i < N; i++) {
                String a = f.next(), b = f.next();
                int c = f.nextInt();
                m.get(a).add(b);
                m.get(b).add(a);
                cost.put(a+b,c);
                cost.put(b+a,c);
            }
            N = f.nextInt();f.nextLine();
            for (int i = 0; i < N; i++) {
                min = Integer.MAX_VALUE;
                Set<String> visited = new LinkedHashSet<>();
                String a =f.next(), b =f.next();
                recur(a,b,0,visited);
                System.out.println(a + " to " + b+":" + min);
            }
            f.nextLine();
        }
        f.close();
    }
    public void recur(String cur, String end, int c,Set<String> visited){
        visited.add(cur);
        if(cur.equals(end)){
            min = Math.min(min,c);
        }
        else{
            for(String neighbor : m.get(cur)){
                if(!visited.contains(neighbor)){
                    recur(neighbor,end,c+cost.get(cur+neighbor),visited);
                }
            }
        }
        visited.remove(cur);
    }
}
