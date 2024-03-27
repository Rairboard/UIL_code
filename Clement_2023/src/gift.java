import java.util.*;
import java.io.*;

public class gift {
    Map<String,List<String>> m;
    public static void main(String[] args) throws Exception {
        new gift().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("gift.dat"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            int c = f.nextInt();
            f.nextLine();
            m = new HashMap<>();
            Set<String> visited = new LinkedHashSet<>();
            for (int i = 0; i < c; i++) {
                String a = f.next(), b = f.next();
                m.putIfAbsent(a,new ArrayList<>());
                m.putIfAbsent(b,new ArrayList<>());
                m.get(a).add(b);
                m.get(b).add(a);
            }
            boolean a = recur("You","Ramsey",visited);
            boolean b = recur("Ramsey","You",visited);
            System.out.println(a || b?"Happy Gifting":"Not So Secret Santa.");
        }
        f.close();
    }
    public boolean recur(String cur, String goal, Set<String> visited){
        visited.add(cur);
        if(cur.equals(goal)){
            visited.remove(cur);
            return true;
        }
        if(m.get(cur)!=null){
            for(String neighbor : m.get(cur)){
                if (!visited.contains(neighbor)) {
                    if (recur(neighbor, goal, visited)) {
                        return true;
                    }
                }
            }
        }
        visited.remove(cur);
        return false;
    }
}