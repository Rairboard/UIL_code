import java.util.*;
import java.io.*;

public class HerosLicense {
    public static void main(String[] args) throws Exception {
        new HerosLicense().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("HerosLicense.in"));
        //Scanner f = new Scanner(System.in);
		Set<Hero> s = new TreeSet<>();
        int times = f.nextInt(), j = f.nextInt();
		f.nextLine();
        while (times-- > 0) {
			String[] l = f.nextLine().split(",\\s+");
			long pow = Long.parseLong(l[1]);
			long power = 0;
			while(pow > 0){
				power += pow%10;
				pow/=10;
			}
			Hero h = new Hero(l[0],power);
			s.add(h);
        }
		int mid = s.size()/2;
		for(Hero hh : s){
			if(mid==0) break;
			System.out.println(hh);
			mid--;
		}
        f.close();
    }
	static class Hero implements Comparable<Hero>{
		String n;
		long p;
		public Hero(String name, long power){
			n = name;
			p = power;
		}
		public int compareTo(Hero h){
			if(p == h.p){
				return n.compareTo(h.n);
			}
			return p < h.p ? 1 : -1;
		}
		public String toString(){
			return n;
		}
	}
}
