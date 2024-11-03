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
			List<Pair> pq = new ArrayList<>();
			int n = f.nextInt(), k = f.nextInt();
			f.nextLine();
			int[] A = new int[n];
			int[] B = new int[n];
			for (int i = 0; i < n; i++) {
				A[i] = f.nextInt();
			}
			for (int i = 0; i < n; i++) {
				B[i] = f.nextInt();
			}
			for (int i = 0; i < n; i++) {
				pq.add(new Pair(A[i],B[i]));
			}
			int total = 0;
			for (int i = 0; i < k; i++) {
				Pair p = pq.get(pq.size()-1);
				total+=p.ai;
				p.ai = Math.max(0,p.ai - p.bi);
				Collections.sort(pq);
			}
			out.println(total);
        }
        f.close();
    }
	class Pair implements Comparable<Pair>{
		int ai, bi;
		public Pair(int a, int b){
			ai = a;
			bi = b;

		}
		public int compareTo(Pair p){
			if(ai==p.ai){
				return bi-p.bi;
			}
			return ai - p.ai;
		}
		public String toString(){
			return "[" + ai + ":" + bi + "]";
		}
	}
}
