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

public class fai2 {
    public static void main(String[] args) throws Exception {
        new fai2().run();
    }
    // using hierholzer algorithm with stack to backtrack when a vertex is out of edges
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("fai").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            Map<String,List<String>> m = new HashMap<>();
            String[] ln = f.nextLine().trim().split(",");
            for (int i = 0; i < ln.length; i++) {
                m.put(ln[i], new ArrayList<>());
            }
            String start = f.nextLine().trim();
            String[] edges = f.nextLine().trim().split(",");
            f.nextLine();
            for (int i = 0; i < edges.length; i++) {
                String[] edge = edges[i].split("<->");
                m.get(edge[0]).add(edge[1]);
                m.get(edge[1]).add(edge[0]);
            }
            if (isEulerian(m)) {
                out.println("Test case " + asdf + ": possible");
                Stack<String> st = new Stack<>();
                List<String> path = new ArrayList<>();
                String cur = start;
                st.push(cur);
                while(!st.isEmpty()){
                    if(!m.get(cur).isEmpty()){
                        st.push(cur);
                       String nextVertex = m.get(cur).getLast();
                       m.get(nextVertex).remove(cur);
                       m.get(cur).remove(nextVertex);
                       cur =nextVertex;
                    }
                    else{
                        path.add(cur);
                        cur = st.pop();
                    }
                }
                for(int i = path.size()-1;i>=1;i--){
                    out.print(path.get(i) + "<->" + path.get(i-1)+" ");
                }
                out.println();
            }
            else{
                out.println("Test case " +asdf + ": impossible");
            }
        }
        f.close();
    }
    public boolean isEulerian(Map<String,List<String>> m){
        for(String v : m.keySet()){
            if(m.get(v).size()%2!=0) return false;
        }
        return true;
    }
}
