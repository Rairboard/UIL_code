import java.util.*;
import java.io.*;
public class hachiro {
	public static void main(String[] args)throws Exception {
		new hachiro().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("hachiro.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        Map<String, int[]> m = new HashMap<>();
        // win, tie, loss, score, gotScore, points
        for(int asdf = 1;asdf <= times;asdf++){
            String a = f.next();
            int goal1 = f.nextInt();
            String b = f.next();
            int goal2 = f.nextInt();
            m.putIfAbsent(a, new int[6]);
            m.putIfAbsent(b, new int[6]);
            m.get(a)[3] += goal1;
            m.get(a)[4] += goal2;
            m.get(b)[3] += goal2;
            m.get(b)[4] += goal1;
            if(goal1 > goal2){
                m.get(a)[0]++;
                m.get(a)[5]+=3;
                m.get(b)[2]++;
            }
            else if(goal2 >goal1){
                m.get(b)[0]++;
                m.get(b)[5]+=3;
                m.get(a)[2]++;
            }
            else{
                m.get(a)[1]++;
                m.get(a)[5]++;
                m.get(b)[1]++;
                m.get(b)[5]++;
            }
        }
        List<Team> al = new ArrayList<>();
        for(String team : m.keySet()){
            int[] stat = m.get(team);
            al.add(new Team(team, stat));
        }
        Collections.sort(al);
        System.out.println("6A District 33 Soccer Table\nTeam      W  T  L  P  GD");
        for(Team t : al){
            System.out.printf("%-8s%3d%3d%3d%3d%4d\n", t.name, t.stat[0], t.stat[1], t.stat[2], t.stat[5], t.stat[3] - t.stat[4]);
        }
        f.close();
	}
    class Team implements Comparable<Team>{
        String name;
        int[] stat;
        public Team(String n, int[] s){
            name = n;
            stat = s;
        }
        public int compareTo(Team o){
            if(o.stat[5] == stat[5]){
                return (o.stat[3] - o.stat[4]) - (stat[3] - stat[4]);
            }
            return o.stat[5] - stat[5];
        }
    }
}
