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

public class collation {
	String ln;
    public static void main(String[] args) throws Exception {
        new collation().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("collation").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			ln = f.nextLine().trim();
			int n = f.nextInt();
			f.nextLine();
			List<Word> al = new ArrayList<>();
			String[] ar = f.nextLine().trim().split("\\s+");
			for (int i = 0; i < ar.length; i++) {
				al.add(new Word(ar[i]));
			}
			Collections.sort(al);
			for(Word w : al){
				out.print(w.s+" ");
			}
			out.println();
        }
        f.close();
    }
	class Word implements Comparable<Word>{
		String s;
		public Word(String w){
			s = w;
		}
		public int compareTo(Word o){
			for(int i = 0;i < Math.min(s.length(),o.s.length());i++){
				if (s.charAt(i) != o.s.charAt(i)) {
					return ln.indexOf(s.charAt(i)) - ln.indexOf(o.s.charAt(i));
				}
			}
			if (s.length() > o.s.length()) {
				return 1;
			}
			if (s.length() < o.s.length()) {
				return -1;
			}
			return 0;
		}
	}
}
