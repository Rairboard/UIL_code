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

public class senate {
	Map<String,Set<String>> m;
	HashSet<String> hs;
    public static void main(String[] args) throws Exception {
        new senate().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("senate").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt(),total=0;
        f.nextLine();
        while (times-- > 0) {
			HashSet<String> senator = new HashSet<>();
			 m = new HashMap<>();
			 hs = new HashSet<>();
			 int n = f.nextInt();
			 f.nextLine();
			for (int i = 0; i < n; i++) {
				String[] ln = f.nextLine().split("-");
				String[] other = ln[1].replaceAll("[\\[\\]]","").split(",");
				senator.add(ln[0]);
				m.putIfAbsent(ln[0],new HashSet<>());
				for (int j = 0; j < other.length; j++) {
					if(!other[j].isEmpty()){
						m.get(ln[0]).add(other[j]);
						m.putIfAbsent(other[j],new HashSet<>());
						m.get(other[j]).add(ln[0]);
						senator.add(other[j]);
					}
				}
			}
			HashSet<String> v = new HashSet<>();
			recur("palpatine",v);
			if(hs.size()>senator.size()/2){
				out.println("\"I am the senate!\"");
			}else{
				out.println("\"It's treason then\"");
				total++;
			}
        }
		out.println("\"Make the Republic Great Again!\" " + total);
		f.close();
    }
	public void recur(String cur,HashSet<String> visited){
		hs.add(cur);
		visited.add(cur);
		if(m.get(cur)==null)return;
		for(String neighbor : m.get(cur)){
			if (!visited.contains(neighbor)){
				recur(neighbor,visited);
			}
		}
		visited.remove(cur);
	}
}
