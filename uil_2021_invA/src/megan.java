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

public class megan {
    public static void main(String[] args) throws Exception {
        new megan().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("megan").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
       for(int t = 1;t<=times;t++) {
			String orig = f.nextLine();
			String[] ln = f.nextLine().split(",");
			if(f.hasNext()){
				f.nextLine();
			}
			List<Word> al =new ArrayList<>();
			for (int i = 0; i < ln.length; i++) {
				al.add(new Word(ln[i],orig));
			}
			Collections.sort(al);
			boolean solved = true;
			for (int i = 0; i < ln.length; i++) {
				if(!al.get(i).w.equals(ln[i])){
					solved = false;
					break;
				}
			}
//           out.println(al);
           out.println("Word List " + t + " is " + (solved?"sorted.":"not sorted."));
        }
        f.close();
    }
	class Word implements Comparable<Word>{
		String w, order;
		public Word(String s, String or){
			w = s;
			order = or;
		}
		public int compareTo(Word o){
			int min = Math.min(w.length(), o.w.length());
			for (int i = 0; i < min; i++) {
				if(order.indexOf(w.substring(i,i+1)) != order.indexOf(o.w.substring(i,i+1))){
					return order.indexOf(w.substring(i,i+1)) - order.indexOf(o.w.substring(i,i+1));
				}
			}
			return w.length() - o.w.length();
		}
        public String toString(){
            return w;
        }
	}
}
