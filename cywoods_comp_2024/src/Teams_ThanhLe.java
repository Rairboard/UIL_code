import java.util.*;
import java.io.File;

public class Teams_ThanhLe {
    List<String> xfactor = new ArrayList<>(Arrays.asList("X-Factor,Superstar,Star,Normal,Benchwarmer".split(",")));
    public static void main(String[] args) throws Exception {
        new Teams_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("teams").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int k = f.nextInt();
            f.nextLine();
            List<Player> al = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                String n = f.next();
                int xf = xfactor.indexOf(f.next());
                double speed = f.nextDouble(), strength = f.nextDouble(), tackle = f.nextDouble(), running = f.nextDouble(), height = f.nextDouble(), weight = f.nextDouble(), fumble = f.nextDouble(), insta = f.nextDouble();
                String[] bd = f.nextLine().trim().split("/");
                int m = Integer.parseInt(bd[0]), d = Integer.parseInt(bd[1]), y = Integer.parseInt(bd[2]);
                al.add(new Player(n, xf, speed, strength, tackle, running, height, weight, fumble, insta, m, d, y));
            }
            Collections.sort(al);
            List<Player> team1 = new ArrayList<>();
            List<Player> team2 = new ArrayList<>();
            for (int i = 0; i < al.size(); i++) {
                if(i + 1 < al.size()){
                    al.get(i).rank = i + 1;
                    al.get(i+1).rank = i + 2;
                    team1.add(al.get(i));
                    team2.add(al.get(i+1));
                    i++;
                }
            }
            if(team1.size()==0||team2.size()==0){
                System.out.println("Not enough players");
            }
            else{
                System.out.println("Team One");
                for (int i = 0; i < team1.size(); i++) {
                    System.out.println(team1.get(i).rank + ". " + team1.get(i).name);
                }
                System.out.println("\nTeam Two");
                for (int i = 0; i < team2.size(); i++) {
                    System.out.println(team2.get(i).rank + ". " + team2.get(i).name);
                }
            }
            System.out.println("-".repeat(10));

        }
        f.close();
    }
    class Player implements Comparable<Player>{
		String name;
        double speed, strength, tackle, running, height, weight, fumble, insta;
        Calendar c;
        int xf, rank;
        public Player(String name, int xf, double speed, double strength, double tackle, double running, double height, double weight, double fumble, double insta, int m, int d, int y){
            this.name = name;
            this.xf = xf;
            this.speed = speed;
            this.strength = strength;
            this.tackle = tackle;
            this.running = running;
            this.height = height;
            this.weight = weight;
            this.fumble = fumble;
            this.insta = insta;
            c = new GregorianCalendar(y, m-1, d);
        }
        public int compareTo(Player p){
            if (name.equals("JoeMixon") || p.name.equals("DeshawnWatson")) {
                return -1;
            }
            if (name.equals("DeshawnWatson")|| p.name.equals("JoeMixon")) {
                return 1;
            }
			if(xf == p.xf){
                if(speed == p.speed){
                    if(strength == p.strength){
                        if(tackle == p.tackle){
                            if(running == p.running){
                                if(height == p.height){
                                    if(weight == p.weight){
                                        if(fumble == p.fumble){
                                            if(insta == 0 && p.insta!=0){
                                                return -1;
                                            }
                                            if(insta!=0 && p.insta==0){
                                                return 1;
                                            }
                                            if(insta == p.insta){
                                                if (c.compareTo(p.c)==0) {
                                                    return name.compareTo(p.name) < 0 ? -1 : 1;
                                                }
                                                return c.compareTo(p.c) < 0 ? -1 : 1;
                                            }
                                            return insta > p.insta ? -1 : 1;
                                        }
                                        return fumble < p.fumble ? -1 : 1;
                                    }
                                    return weight > p.weight ? -1 : 1;
                                }
                                return height > p.height ? -1 : 1;
                            }
                            return running > p.running ? -1 : 1;
                        }
                        return tackle > p.tackle ? -1 : 1;
                    }
                    return strength > p.strength ? -1 : 1;
                }
                return speed > p.speed ? -1 : 1;
            }
            return xf < p.xf ? -1 : 1;
        }
    }
}
