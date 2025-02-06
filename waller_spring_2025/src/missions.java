import java.io.*;
import java.util.*;

public class missions {
    public static void main(String[] args) throws Exception {
        new missions().run();
    }

    public void run() throws Exception {
//        Scanner in = new Scanner(System.in);
        Scanner f = new Scanner(new File("missions.dat"));

        xmen = new XMen[10];

        xmen[0] = new XMen("Colossus");
        xmen[0].skills.add("Strength");
        xmen[0].skills.add("Invulnerability");

        xmen[1] = new XMen("Wolverine");
        xmen[1].skills.add("Hand-to-Hand");
        xmen[1].skills.add("Invulnerability");

        xmen[2] = new XMen("Nightcrawler");
        xmen[2].skills.add("Teleportation");
        xmen[2].skills.add("Swords");
        xmen[2].skills.add("Hand-to-Hand");
        xmen[2].skills.add("Agility");

        xmen[3] = new XMen("Storm");
        xmen[3].skills.add("Flight");
        xmen[3].skills.add("Electric");
        xmen[3].skills.add("Cold");

        xmen[4] = new XMen("Banshee");
        xmen[4].skills.add("Flight");
        xmen[4].skills.add("Energy-Blasts");

        xmen[5] = new XMen("Cyclops");
        xmen[5].skills.add("Hand-to-Hand");
        xmen[5].skills.add("Energy-Blasts");

        xmen[6] = new XMen("Phoenix");
        xmen[6].skills.add("Flight");
        xmen[6].skills.add("Telekinesis");
        xmen[6].skills.add("Telepathy");
        xmen[6].skills.add("Energy-Blasts");

        xmen[7] = new XMen("Iceman");
        xmen[7].skills.add("Cold");
        xmen[7].skills.add("Invulnerability");

        xmen[8] = new XMen("Beast");
        xmen[8].skills.add("Strength");
        xmen[8].skills.add("Agility");

        xmen[9] = new XMen("Angel");
        xmen[9].skills.add("Flight");
        xmen[9].skills.add("Swords");

        int N = f.nextInt();
        f.nextLine();

        while (N-- > 0){
            treeSet = new TreeSet<>();
            String[] line = f.nextLine().trim().split("\\s+");
            recur(line, 0, "");

            if (treeSet.isEmpty()){
                System.out.println(0);
                System.out.println();
            }
            else{
                System.out.println(treeSet.size());
                System.out.println(treeSet.first());
            }
            System.out.println(treeSet);
        }
    }

    XMen[] xmen;
    TreeSet<String> treeSet;

    public void recur(String[] req, int ind, String cur){
        if (ind == req.length){
            treeSet.add(cur.strip());
            return;
        }

        for (int i = 0; i < 10; i++){
            if (!cur.contains(xmen[i].name) && xmen[i].skills.contains(req[ind])){
                recur(req, ind+1, cur+" "+xmen[i].name);
            }
        }

    }

    class XMen{
        String name;
        HashSet<String> skills;

        public XMen(String name){
            this.name = name;
            skills = new HashSet<>();
        }

    }

}