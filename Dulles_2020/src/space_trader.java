import java.util.*;
import java.io.File;

public class space_trader {
    Map<String,List<String>> m;
    Map<String,Integer> cost;
    int maxP;
    public static void main(String[] args) throws Exception {
        new space_trader().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("space_trader.dat"));
        //Scanner f = new Scanner(System.in);
        m = new HashMap<>();
        cost = new HashMap<>();
        String start = f.next();f.nextLine();
        while(f.hasNext()){
            String[] ln = f.next().split("/");
            f.next();
            int c = f.nextInt();
            m.putIfAbsent(ln[0],new ArrayList<>());
            m.putIfAbsent(ln[1],new ArrayList<>());
            m.get(ln[0]).add(ln[1]);
            m.get(ln[1]).add(ln[0]);
            cost.put(ln[0]+ln[1],c);
            cost.put(ln[1]+ln[0],c);
        }
        maxP = 0;
        Set<String> v = new HashSet<>();
        recur(start,v,0,0);
        System.out.println(maxP);
        f.close();
    }
    public void recur(String cur, Set<String> visited,int cc,int planet){
        if(cc<=50){
            visited.add(cur);
            if(m.get(cur)==null) return;
            for(String np : m.get(cur)){
                if (!visited.contains(np)) {
                    recur(np,visited,cc+cost.get(cur+np),planet+1);
                }
            }
            visited.remove(cur);
        }else{
            maxP = Math.max(maxP,planet);
        }
    }
}
