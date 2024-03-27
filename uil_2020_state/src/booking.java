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

public class booking {
    public static void main(String[] args) throws Exception {
        new booking().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("booking").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n = f.nextInt();
			f.nextLine();
			List<Person> al = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String[] ln = f.nextLine().split("\\s+");
				al.add(new Person(ln[0],ln[1],Integer.parseInt(ln[2])));
			}
			Collections.sort(al);
			for (int i = 0; i < al.size(); i++) {
				out.println(al.get(i));
			}
			out.println();
        }
        f.close();
    }
	class Person implements Comparable<Person>{
		String f,l;
		int room;
		public Person(String first, String last, int r){
			f = first;
			l = last;
			room = r;
		}
		public int compareTo(Person o){
			if(room == o.room){
				if (l.equals(o.l)) {
					return f.compareTo(o.f);
				}
				return l.compareTo(o.l);
			}
			return room - o.room;
		}
		public String toString(){
			return f + " " + l;
		}
	}
}
