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

public class Isfl {
    public static void main(String[] args) throws Exception {
        new Isfl().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Isfl").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            Map<String,List<String>> hm = new LinkedHashMap<>();
            List<String> leftover = new ArrayList<>();
            Set<Team> s = new TreeSet<>();
            int n = f.nextInt();
            f.nextLine();
            for (int i = 0; i < n; i++) {
                String[] l = f.nextLine().split("-");
                if(l.length==2){
                    hm.putIfAbsent(l[1],new ArrayList<>());
                    hm.get(l[1]).add(l[0]);
                }else{
                    leftover.add(l[0]);
                }
            }
            for(String team : hm.keySet()){
                List<String> al = new ArrayList<>();
                for (int i = 0; hm.get(team).size()>0 && i < 3; i++) {
                    al.add(hm.get(team).remove(0));
                }
                s.add(new Team(team,al));
                while(hm.get(team).size()>0){
                    leftover.add(hm.get(team).remove(0));
                }
            }
            int unt = 1;
            while(leftover.size()>0){
                List<String> tmp = new ArrayList<>();
                for (int i = 0; i < 3 && leftover.size() > 0; i++) {
                    tmp.add(leftover.remove(0));
                }
                s.add(new Team("Untitled Team " + unt++,tmp));
            }
            List<Team> all = new ArrayList<>(s);
            for (int i = 0; i < all.size(); i++) {
                out.println(all.get(i).name);
                for(String p : all.get(i).al){
                    out.println(p);
                }
                if(i<all.size()-1){
                    out.println();
                }
            }
            out.println("-----");
        }
        f.close();
    }
    class Team implements Comparable<Team>{
        String name;
        List<String> al;
        public Team(String n, List<String> people){
            name = n;
            al =  new ArrayList<>(people);
            Collections.sort(al);
        }
        public int compareTo(Team o){
            return name.compareTo(o.name);
        }
    }
}
