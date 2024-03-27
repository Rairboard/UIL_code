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

public class noah {
    public static void main(String[] args) throws Exception {
        new noah().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("noah").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		Map<String,Integer> make = new TreeMap<>(), model = new TreeMap<>();
		Map<Integer,Integer> year = new TreeMap<>();
        int times = f.nextInt();
        f.nextLine();
		List<V> al = new ArrayList<>();
        for (int asdf = 1; asdf <= times; asdf++) {
			String[] ln = f.nextLine().split(",");
			make.put(ln[0], make.getOrDefault(ln[0],0)+1);
			model.put(ln[1],model.getOrDefault(ln[1],0)+1);
			year.put(Integer.parseInt(ln[2]),year.getOrDefault(Integer.parseInt(ln[2]),0)+1);
			al.add(new V(ln[0],ln[1],Integer.parseInt(ln[2])));
        }
		Collections.sort(al);
		out.println("---Data Sorted---");
		for (int i = 0; i < al.size(); i++) {
			out.println(al.get(i).make + " " + al.get(i).model + " " + al.get(i).year);
		}
		out.println("\n---Make Breakdown---");
		for(String s : make.keySet()){
			out.println(s +": " + make.get(s));
		}
		out.println("\n---Model Breakdown---");
		for(String s : model.keySet()){
			out.println(s +": " + model.get(s));
		}
		out.println("\n---Year Breakdown---");
		for(Integer i : year.keySet()){
			out.println(i + ": " + year.get(i));
		}

        f.close();
    }
	class V implements Comparable<V>{
		String make, model;
		int year;
		public V(String m1, String m2, int y){
			make =m1;
			model= m2;
			year = y;
		}
		public int compareTo(V o){
			if (make.equals(o.make)) {
				if (model.equals(o.model)) {
					return year-o.year;
				}
				return model.compareTo(o.model);
			}
			return make.compareTo(o.make);
		}
	}
}
