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

public class mathabet {
    public static void main(String[] args) throws Exception {
        new mathabet().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("mathabet").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
		List<E> al = new ArrayList<>();
        while (times-- > 0) {
			String ln = f.nextLine();
			String num = "";
			for (int i = 0; i < ln.length(); i++) {
				num+=ln.charAt(i)-96;
			}
//			out.println(ln + " " + num);
			al.add(new E(ln,Long.parseLong(num)));
        }
		Collections.sort(al);
		Collections.reverse(al);
		for (int i = 0; i < al.size(); i++) {
			out.println(al.get(i).n);
		}
        f.close();
    }
	class E implements Comparable<E>{
		long id;
		long N;
		String n;
		public E(String s, long num){
			n = s;
			N = num;
			if(BigInteger.valueOf(num).isProbablePrime(1)){
				id = 0;
			}else{
				id = 1;
			}
		}
		public int compareTo(E o){
			if(id == o.id){
				if(N % 2 == o.N % 2){
					return N < o.N ? 1 : -1;
				}
				return N % 2 == 1 ? 1 : -1;
			}
			return id > o.id ? 1 : -1;
		}
	}
}
