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

public class bookface {
	Map<String,List<String>> m;
	Map<Integer,Set<String>> con;
    public static void main(String[] args) throws Exception {
        new bookface().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bookface").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt(), p = f.nextInt();
        f.nextLine();
		m = new HashMap<>();
        while (times--> 0) {
			String[] ln = f.nextLine().split("\\s+");
			String a = ln[0] + " " + ln[1];
			String b = ln[2] + " " + ln[3];
			m.putIfAbsent(a,new ArrayList<>());
			m.putIfAbsent(b,new ArrayList<>());
			m.get(a).add(b);
			m.get(b).add(a);
        }
		while(p-->0){
			String[] w = "one,two,three".split(",");
			String ln = f.nextLine();
			con = new HashMap<>();
			HashSet<String> visited = new HashSet<>();
			Map<Integer,List<Person>> list = new TreeMap<>();
			for (int i = 1; i <= 3; i++) {
				list.put(i,new ArrayList<>());
				con.put(i,new HashSet<>());
			}
			recur(ln,visited,-1);
			for (int i = 1; i <= 3; i++) {
				if(!con.get(i).isEmpty()){
					for(String person : con.get(i)){
						String[] name = person.split("\\s+");
						list.get(i).add(new Person(name[0],name[1]));
					}
				}
			}
			out.println(ln);
			for(Integer ii : list.keySet()){
				out.print("Users that are " + w[ii-1] + (ii > 1 ? " connections ":" connection ") + "away: ");
				if(list.get(ii).isEmpty()){
					out.println("No users are " + w[ii-1] +  (ii > 1 ? " connections ":" connection ") + "away");
				}else{
					Collections.sort(list.get(ii));
					for (int i = 0; i < list.get(ii).size(); i++) {
						out.print(list.get(ii).get(i));
						if(i<list.get(ii).size()-1){
							out.print(", ");
						}
					}
					out.println();
				}
			}
		}
        f.close();
    }
	public void recur(String cur, HashSet<String> visited, int step){
		if(!visited.contains(cur)){
			if(step >= 1  && step <= 3){
				con.get(step).add(cur);
			}
			visited.add(cur);
			if(m.get(cur)==null){
				return;
			}
			for(String neighbor : m.get(cur)){
				recur(neighbor,visited,step+1);
			}
			visited.remove(cur);
		}
	}
	class Person implements Comparable<Person>{
		String fn, ln;
		public Person(String fn, String ln){
			this.fn = fn;
			this.ln = ln;
		}
		public int compareTo(Person o){
			if (ln.equals(o.ln)) {
				return fn.compareTo(o.fn);
			}
			return ln.compareTo(o.ln);
		}
		public String toString(){
			return fn + " " + ln;
		}
	}
}
