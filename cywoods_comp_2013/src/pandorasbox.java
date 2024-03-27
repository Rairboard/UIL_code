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

public class pandorasbox {
    public static void main(String[] args) throws Exception {
        new pandorasbox().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("pandorasbox").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int time = 1; time <= times; time++){
			String s = f.next(), e = f.next();
			int n = f.nextInt(),min = Integer.MAX_VALUE;
			boolean solved = false;
			String[] b = new String[n];
			for (int i = 0; i < n; i++) {
				b[i] = f.next();
			}
			Queue<Combination> q = new LinkedList<>();
			Map<String,Integer> visited = new HashMap<>();
			visited.put(s,Integer.MAX_VALUE);
			q.offer(new Combination(s,0));
			while(!q.isEmpty()){
				Combination cc = q.poll();
				String cur = cc.c;
				int step = cc.s;
				if(step<visited.get(cur)){
					if (cur.equals(e)) {
						solved = true;
						min = Math.min(step,min);
						continue;
					}
					visited.put(cur,step);
					for (int i = 0; i < b.length; i++) {
						String ll = update(cur,b[i]);
						if (!visited.containsKey(ll)) {
							visited.put(ll,Integer.MAX_VALUE);
						}
						q.offer(new Combination(ll,step+1));
					}
				}
			}
			out.println("Case " + time + ": " + (solved?min:"Cannot be Opened"));
        }
        f.close();
    }
	class Combination{
		String c;
		int s;
		public Combination(String cc,int step){
			c = cc;
			s = step;
		}
	}
	public String update(String a,String b){
		String res = Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
		if(res.length()<4){
			return String.format("%04d",Integer.parseInt(res));
		}
		return res.substring(res.length()-4);
	}
}