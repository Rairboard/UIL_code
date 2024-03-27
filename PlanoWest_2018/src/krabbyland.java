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

public class krabbyland {
    public static void main(String[] args) throws Exception {
        new krabbyland().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("krabbyland").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			int p = f.nextInt(), min = f.nextInt() * 365 + f.nextInt();
			f.nextLine();
			List<Creature> al = new ArrayList<>();
			for (int i = 0; i < p; i++) {
				al.add(new Creature(f.next(),f.nextInt(),f.nextInt()));
			}
			Collections.sort(al);
			int adult = 0;
			for (int i = 0; i < al.size(); i++) {
				if(al.get(i).age >= min){
					adult++;
					p--;
				}
			}
			for(int x = 0; x < adult;x++){
				for (int i = 0; i < 2 && !al.isEmpty(); i++) {
					al.removeLast();
					p--;
				}
			}
			for (int i = 0; i < adult && !al.isEmpty(); i++) {
				al.removeFirst();
			}
			int  time = 0;
			while(!al.isEmpty()){
				time = Math.max(time,min - al.removeFirst().age);
				for (int i = 0; i < 2 && !al.isEmpty(); i++) {
					al.removeLast();
				}
			}
			int y = time / 365;
			int d = time % 365;
			out.printf("%d year(s) and %d day(s)\n",y,d);
		}
        f.close();
    }
	class Creature implements Comparable<Creature>{
		String name;
		int age;
		public Creature(String n, int y, int d){
			name = n;
			age = y *365 + d;
		}
		public int compareTo(Creature o ){
			return o.age - age;
		}
		public String toString(){
			return name + " " + age;
		}
	}
}
