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

public class logan {
    public static void main(String[] args) throws Exception {
        new logan().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("logan.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			Set<Bag> s = new TreeSet<>();
			List<String> total = new ArrayList<>();
			List<String> used = new ArrayList<>();
			int cap = f.nextInt();
			int N = f.nextInt();
			int money = 0;
			int weight = 0;
			for(int i=0;i<N;i++){
				int value = f.nextInt(), amt = f.nextInt();
				String color = f.next();
				s.add(new Bag(value,amt,color));
				total.add(color);
			}
			for(Bag b : s){
				if(weight==cap){
					break;
				}
				if(weight + b.w > cap){
					continue;
				}
				weight += b.w;
				money += b.v;
				used.add(b.c);
			}
			out.println(cap + "\n" + weight + "\n$" + money);
			total.removeIf(e -> !used.contains(e));
			total.forEach(e -> out.println(e));
        }
        f.close();
    }
	class Bag implements Comparable<Bag>{
		int v, w;
		double p;
		String c;
		public Bag(int value, int weight, String color){
			v = value;
			w = weight;
			c = color;
			p = (double)v/w;
		}
		public int compareTo(Bag b){
			return p < b.p ? 1 : -1;
		}
	}
}
