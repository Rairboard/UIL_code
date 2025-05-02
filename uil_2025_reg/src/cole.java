import java.util.*;
import java.io.*;
public class cole {
    Map<String,Item> m;
    Map<String,Double> total;
	public static void main(String[] args)throws Exception {
		new cole().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("cole.dat"));
        //Scanner f = new Scanner(System.in);
        int R = f.nextInt(), Q =f.nextInt();
        f.nextLine();
        m = new HashMap<>();
        for (int i = 0; i < R; i++) {
            String[] ln = f.nextLine().trim().split(",\\s+");
            String[] rate = ln[1].split("/");
            Item item = new Item(ln[0], Double.parseDouble(rate[0])/Double.parseDouble(rate[1]));
            m.put(ln[0], item);
            for (int j = 3; j < ln.length; j+=2) {
                String inputName = ln[j].substring(1);
                int number = Integer.parseInt(ln[j+1].substring(0,ln[j+1].length()-1));
                m.get(ln[0]).edge.put(inputName, number);
//                System.out.println(Arrays.toString(input));
            }
        }
        for (int i = 0; i < Q; i++) {
            String[] ln = f.nextLine().trim().split(",\\s+");
            String name = ln[0];
            double rate = Double.parseDouble(ln[1]);
            rate-=1e-6;
            recur(name, rate/m.get(name).rate);
            total = new HashMap<>();
            System.out.printf("%s (%.5f/s):\n", name, rate);
            for(String input : total.keySet()){
                System.out.printf("\t%s: %d\n", Math.round(total.get(input) - 1e6));
            }
        }
        f.close();
	}
    public void recur(String cur, double amount){
        total.put(cur, total.getOrDefault(cur,0.)+amount);
        if(m.get(cur).edge.isEmpty()) return;
        for(String input : m.get(cur).edge.keySet()){
            recur(input, amount/ m.get(cur).rate);
        }
    }
    class Item {
        Map<String,Integer> edge;
        String name;
        double rate;
        public Item(String n, double r){
            name = n;
            rate =r ;
            edge = new HashMap<>();
        }
    }
}
