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

public class descendants {
    Map<Integer,List<Node>> m;
    Map<Integer,Node>ID;
    public static void main(String[] args) throws Exception {
        new descendants().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("descendants").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
         m = new HashMap<>();
        ID =new HashMap<>();
        for (int asdf = 1; asdf <= times; asdf++) {
            String name = f.next();
            int id = f.nextInt();
            int pid = f.nextInt();
            m.putIfAbsent(pid, new ArrayList<>());
            m.get(pid).add(new Node(id,name));
            ID.put(id, new Node(id,name));
        }
        for(Integer i : m.keySet()){
            Collections.sort(m.get(i));
        }
        out.println("root");
        for(Node child : m.get(1)){
            recur(1, child.id, new HashSet<>());
        }
        f.close();
    }
    public void recur(int dash, int id,Set<Integer> visited){
        if(visited.contains(id)) return;
        visited.add(id);
        out.println("-".repeat(dash) + ID.get(id).name);
        if(m.get(id)==null) return;
        for(Node child : m.get(id)){
            recur(dash+1,child.id,visited);
        }
    }
    class Node implements Comparable<Node>{
        int id;
        String name;
        public Node(int i, String n){
            id = i;
            name =n;
        }
        public int compareTo(Node o){
            return name.compareTo(o.name);
        }
        public String toString(){
            return name + " " + id;
        }
    }
}
