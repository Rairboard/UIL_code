import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class howard {
    public static void main(String[] args) throws Exception {
        new howard().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("howard").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String[] pos = "PG,SG,SF,PF,C".split(",");
        Map<String,List<Player>> m = new HashMap<>();
        for (int i = 0; i < pos.length; i++) {
            m.put(pos[i],new ArrayList<>());
        }
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().split("\\s+");
            long number = Long.parseLong(ln[0]);
            String name = ln[1];
            String position = ln[2];
            m.get(position).add(new Player(number,name,position,Double.parseDouble(ln[3]),Double.parseDouble(ln[4]),Double.parseDouble(ln[5]),Double.parseDouble(ln[6]),Double.parseDouble(ln[7])));
        }
        for (int i = 0; i < pos.length  ; i++) {
            Collections.sort(m.get(pos[i]));
            Player player = m.get(pos[i]).get(0);
            out.println(player.position+": " + player.number+". " + player.name);
        }
        f.close();
    }
    class Player implements Comparable<Player>{
        String name;
        String position;
        long number;
        double ts;
        double atr;
        public Player(long number, String name, String position, double pts, double apg, double fga, double fta, double tpg){
            this.number = number;
            this.name =name;
            this.position = position;
            ts = pts;
            double denominator = 2 * (fga + 0.44 * fta);
            if(denominator!=0){
                ts/=denominator;
            }
            else{
                ts = Double.MAX_VALUE;
            }
            atr = apg;
            if(tpg!=0){
                atr/=tpg;
            }
            else{
                atr = Double.MAX_VALUE;
            }
        }
        public int compareTo(Player o){
            if(ts == o.ts){
                return Double.compare(o.atr,atr);
            }
            return Double.compare(o.ts,ts);
        }
    }
}
