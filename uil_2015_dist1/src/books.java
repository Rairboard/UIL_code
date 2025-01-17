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

public class books {
    public static void main(String[] args) throws Exception {
        new books().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("books").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			double w = f.nextDouble();
			int n = f.nextInt();
			double[] weight = new double[n];
			for (int i = 0; i < n; i++) {
				weight[i] = f.nextDouble();
			}
			PriorityQueue<Item> pq = new PriorityQueue<>();
			pq.offer(new Item(0,0));
			int max = 0;
			while(!pq.isEmpty()){
				Item cur = pq.remove();
				double curWeight = cur.weight;
				int amount = cur.amount;
				max = Math.max(max, amount);
				for (int i = 0; i < n; i++) {
					if (curWeight + weight[i] <= w && !cur.used.contains(i)) {
						Item ii = new Item(curWeight + weight[i], amount + 1);
						ii.used = new HashSet<>(cur.used);
						ii.used.add(i);
						pq.offer(ii);
					}
				}
			}
			out.println(max);
        }
        f.close();
    }
	class Item implements Comparable<Item>{
		double weight;
		int amount;
		Set<Integer> used;
		public Item(double w, int a){
			weight = w;
			amount = a;
			used = new HashSet<>();
		}
		public int compareTo(Item o){
			if(o.amount == amount){
				return Double.compare(weight,o.weight);
			}
			return o.amount - amount;
		}
	}
}
