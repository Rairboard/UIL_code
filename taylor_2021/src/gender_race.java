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

public class gender_race {
    public static void main(String[] args) throws Exception {
        new gender_race().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File("gender_race.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
		List<Racer> overall = new ArrayList<>();
		List<Racer> female = new ArrayList<>();
		List<Racer> male = new ArrayList<>();
        while (times-- > 0) {
			String name = f.next();
			int speed = f.nextInt();
			String gender = f.next();
			overall.add(new Racer(name,speed,gender));
			if(gender.equals("F")){
				female.add(new Racer(name,speed,gender));
			}else if(gender.equals("M")){
				male.add(new Racer(name,speed,gender));
			}
        }
		Collections.sort(overall);
		Collections.sort(male);
		Collections.sort(female);
		for (int i = 0; i < 2; i++) {
			out.println(overall.get(i));
		}
		for (int i = 0; i < 2; i++) {
			out.println(male.get(i));
		}
		for (int i = 0; i < 2; i++) {
			out.println(female.get(i));
		}
        f.close();
    }
	class Racer implements Comparable<Racer>{
		String n, g;
		int s;
		public Racer(String name, int speed, String gender){
			n = name;
			s = speed;
			g = gender;
		}
		public int compareTo(Racer o){
			return s > o.s?1 :-1;
		}
		public String toString(){
			return n +  " " + s + " " + g;
		}
	}
}
