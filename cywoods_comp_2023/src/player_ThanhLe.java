import java.util.*;
import java.io.File;

public class player_ThanhLe {
    List<String> al = new ArrayList<>(Arrays.asList("point guard,shooting guard,small forward,power forward,center".split(",")));
    public static void main(String[] args) throws Exception {
        new player_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("player_judge.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int N = f.nextInt();
            f.nextLine();
            Set<Player> s = new TreeSet<>();
            int in = 1;
            for (int i = 0; i < N; i++) {
                String[] ln = f.nextLine().split("\\s+-\\s+");
                String[] l = ln[1].split("\\s+");
                if(Double.parseDouble(l[4]) >= 175){
                    s.add(new Player(ln[0],Double.parseDouble(l[1]),Double.parseDouble(l[0]),Integer.parseInt(l[2]),Double.parseDouble(l[3]),Double.parseDouble(l[4])));
                }
            }
            for(Player p : s){
                System.out.println("#" + in++ + ": " + p.n + " - " + al.get(p.p-1));
            }
            System.out.println("*".repeat(15));
        }
        f.close();
    }
    class Player implements Comparable<Player>{
        String n;
        int p;
        double ss,vj,h,w;
        public Player(String name, double shootingskill, double height, int position, double verticalJump,double weight){
            n = name;
            ss = shootingskill;
            h = height;
            p = position;
            vj = verticalJump;
            w = weight;
        }
        public int compareTo(Player o){
            if(ss != o.ss){
                return ss < o.ss ? 1 : -1;
            }
            if(h != o.h){
                return h < o.h ? 1 : -1;
            }
            if(p != o.p){
                return p > o.p ? 1 : -1;
            }
            if(vj != o.vj){
                return vj < o.vj ? 1 : -1;
            }
            if(w != o.w){
                return w < o.w ? 1 : -1;
            }
            return n.compareTo(o.n);
        }
    }
}
