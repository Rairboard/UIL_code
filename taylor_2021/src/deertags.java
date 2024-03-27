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

public class deertags {
	class Cause implements Comparable<Cause> {
		String c;
		double p;
		public Cause(String cause, double percent){
			c = cause;
			p = percent;
		}
		public int compareTo(Cause o){
			return p < o.p ? 1 : -1;
		}
		public String toString(){
			return c + " " + Math.round(p) + "%";
		}
	}
    public static void main(String[] args) throws Exception {
        new deertags().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("deertags.dat"));
//        Scanner f = new Scanner(System.in);
		List<String> al = new ArrayList<>();
		Set<Cause> causes = new TreeSet<>();
		int dead = 0;
		Map<String,Double> m = new HashMap<>();
		m.put("NATURAL CAUSES",0.0);
		m.put("MOUNTAIN LION",0.0);
		m.put("COYOTE",0.0);
		m.put("BEAR",0.0);
        while (f.hasNext()) {
			String s = f.nextLine();
			String[] l = s.split("\\s+");
			if(l[1].equals("OK")){
				continue;
			}
			if(l[1].equals("NEW")){
				al.add(l[0]);
			}
			if(l[1].equals("DEAD")){
				dead++;
				String[] cause = s.split(" DEAD - ");
				m.put(cause[1],m.get(cause[1])+1);
			}
        }
		for(String s : m.keySet()){
			causes.add(new Cause(s,m.get(s)/al.size() * 100));
		}
		out.println("ALIVE " + Math.round((double)(al.size()-dead)/al.size() * 100) + "%");
		for(Cause cc : causes){
			out.println(cc);
		}
        f.close();
    }
}
