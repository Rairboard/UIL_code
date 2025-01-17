import java.sql.Array;
import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class yahtzee {
    public static void main(String[] args) throws Exception {
        new yahtzee().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("yahtzee").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            List<Player> al = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                String s = f.next();
                int[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                Map<Integer,Integer> cnt = new HashMap<>();
                for (int j = 0; j < ar.length; j++) {
                    cnt.put(ar[j],cnt.getOrDefault(ar[j],0)+1);
                }
                al.add(new Player(s, cnt));
            }
            Collections.sort(al);
            int haveYahtzee = 0;
            for (int i = 0; i < al.size(); i++) {
                if(al.get(i).yahtzee){
                    haveYahtzee++;
                }
            }
            if(haveYahtzee>1){
                int bestYahtzee = al.getLast().val;
                int cntBest = 1;
                TreeSet<String> names = new TreeSet<>();
                names.add(al.getLast().name);
                for(int i = 0;i < al.size()-1;i++){
                    if(al.get(i).yahtzee && al.get(i).val == bestYahtzee){
                        cntBest++;
                        names.add(al.get(i).name);
                    }
                }
                if(cntBest>1){
                    out.print("TIE ");
                    for(String s : names){
                        out.print(s+" ");
                    }
                    out.println();
                }
                else{
                    out.println(al.getLast().name);
                }
            }
            else if(haveYahtzee==1){
                out.println(al.getLast().name);
            }
            else{
                out.println("NO WINNER");
            }
        }
        f.close();
    }
    class Player implements Comparable<Player>{
        String name;
        boolean yahtzee;
        Map<Integer,Integer> cnt;
        int val;
        public Player (String n, Map<Integer,Integer> m){
            name =n;
            cnt = m;
            if(m.size()==1 && new ArrayList<>(m.values()).getFirst()==5){
                yahtzee = true;
                val = new ArrayList<>(m.keySet()).getFirst();
            }
        }
        public int compareTo(Player o){
            if(yahtzee && o.yahtzee){
                return val - o.val;
            }
            if(!yahtzee&&o.yahtzee){
                return -1;
            }
            if(yahtzee&&!o.yahtzee){
                return 1;
            }
            return 0;
        }
    }
}
