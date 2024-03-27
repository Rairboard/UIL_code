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

public class isabel {
	SimpleDateFormat ff = new SimpleDateFormat("EEEE, MMMM,");
    public static void main(String[] args) throws Exception {
        new isabel().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("isabel.dat"));
        //Scanner f = new Scanner(System.in);
		Set<Person> s = new TreeSet<>();
		while(f.hasNext()){
			s.add(new Person(f.next(), f.nextInt(), f.nextInt()-1,f.nextInt()));
		}
		for(Person p : s){
			out.println(p);
		}
        f.close();
    }
	class Person implements Comparable<Person>{
		String n;
		int y, m , d, dow;
		Calendar c;
		public Person(String name, int year, int month, int day){
			n = name;
			y = year;
			m = month;
			d =day;
			c = new GregorianCalendar(y,m,d);
			dow = c.get(Calendar.DAY_OF_WEEK);
		}
		public int compareTo(Person o){
			if(dow != o.dow){
				return dow > o.dow ? 1 : -1;
			}
			return n.compareTo(o.n) > 0 ? 1 : -1;
		}
		public String toString(){
			return String.format("%-9s : ", n) + ff.format(c.getTime()) + d + ", " + y;
		}
	}
}
