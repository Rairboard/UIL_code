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

public class juliana {
    Map<String,List<String>> m;
    Map<String,Long> year;
    Map<String,String[]> job;
    HashSet<String> candidate;
    public static void main(String[] args) throws Exception {
        new juliana().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("juliana").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int n = f.nextInt(), e = f.nextInt();
        f.nextLine();
        m = new HashMap<>();
        year = new HashMap<>();
        job = new HashMap<>();

        for (int asdf = 1; asdf <= e; asdf++) {
            String[] ln = f.nextLine().trim().split(": ");
            String[] info = ln[1].split("\\s+");
            year.put(ln[0],Long.parseLong(info[0]));
            job.put(ln[0],new String[]{info[1],info[2]});
            m.putIfAbsent(ln[0],new ArrayList<>());
            for(int i = 3;i<info.length;i+=2){
                m.get(ln[0]).add(info[i] + " " +info[i+1]);
            }
        }

        for (int asdf = 0; asdf < n; asdf++) {
            String name = f.nextLine().trim();
            String[] info = f.nextLine().trim().split("\\s+");
            long y = Long.parseLong(info[0]);
            String j = info[1];
            candidate = new HashSet<>();
            for(String node : m.get(name)){
                recur(node, new HashSet<>(), y,j);
            }
            candidate.remove(name);
            List<String> al =new ArrayList<>(candidate);
            Collections.sort(al);
            for (int i = 0; i < al.size(); i++) {
                if(i<al.size()-1) out.print(al.get(i)+", ");
                else out.print(al.get(i));
            }
            out.println();
        }
        f.close();
    }
    public void recur(String cur, HashSet<String> visited, long y, String j){
        if(visited.contains(cur)) return;
        if(year.get(cur)!=null && job.get(cur)!=null){
            if(year.get(cur)>= y && (job.get(cur)[0].equals(j) || job.get(cur)[1].equals(j))){
                candidate.add(cur);
            }
        }
        if(m.get(cur)==null) return;
        visited.add(cur);
        for(String n : m.get(cur)){
            recur(n, visited, y,j);
        }
        visited.remove(cur);
    }
}
