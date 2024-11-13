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

public class bomb_ThanhLe {
    public static void main(String[] args) throws Exception {
        new bomb_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bomb").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			int n = f.nextInt(), k = f.nextInt();
			f.nextLine();
			long[] A = new long[n];
			long[] B = new long[n];
			for (int i = 0; i < n; i++) {
				A[i] = f.nextLong();
			}
			for (int i = 0; i < n; i++) {
				B[i] = f.nextLong();
			}
			for (int i = 0; i < n; i++) {
				pq.add(new Pair(A[i],B[i]));
			}
			long total = 0;
			for (int i = 0; i < k; i++) {
				Pair p = pq.poll();
				total+=p.ai;
				long maxCur = Math.max(0,p.ai-p.bi);
				pq.offer(new Pair(maxCur,p.bi));
			}
			out.println(total);
        }
        f.close();
    }
	class Pair implements Comparable<Pair>{
		long ai, bi;
		public Pair(long a, long b){
			ai = a;
			bi = b;
		}
		public int compareTo(Pair p){
			if(ai==p.ai){
				return Long.compare(p.bi,bi);
			}
			return Long.compare(p.ai,ai);
		}
		public String toString(){
			return "[" + ai + ":" + bi + "]";
		}
	}
}
