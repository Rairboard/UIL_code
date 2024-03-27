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

public class dad {
	Map<String,List<String>> m;
	boolean solved;
    public static void main(String[] args) throws Exception {
        new dad().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dad").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			m = new HashMap<>();
			int n = f.nextInt();
			f.nextLine();
			while(n-->0){
				String a = f.nextLine(), b = f.nextLine();
				m.putIfAbsent(a,new ArrayList<>());
				m.get(a).add(b);
			}
			n = f.nextInt();
			f.nextLine();
			while(n-->0){
				solved = false;
				String a = f.nextLine(),b = f.nextLine();
				Queue<String> q = new LinkedList<>();
				q.offer(a);
				HashSet<String> visited = new HashSet<>();
				while(!q.isEmpty()){
					String cur = q.poll();
					if(cur.equals(b)){
						solved = true;
						break;
					}
					if (visited.contains(cur)) {
						continue;
					}
					visited.add(cur);
					if(m.get(cur)!=null){
						q.addAll(m.get(cur));
					}
				}
				out.println(solved?a + "'s dad can beat up " + b + "'s dad.":a + "'s dad isn't bad enough.");
			}
			out.println();
        }
        f.close();
    }
}
