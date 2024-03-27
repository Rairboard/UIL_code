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

public class prob17 {
    public static void main(String[] args) throws Exception {
        new prob17().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("prob17").toLowerCase() + "-1-in.txt"));
//        Scanner f = new Scanner(System.in);
		String ln = f.nextLine();
		Map<Character,Integer> a = new TreeMap<>(Collections.reverseOrder()), b = new TreeMap<>();
		for (int i = 0; i < ln.length(); i++) {
			a.put(ln.charAt(i),a.getOrDefault(ln.charAt(i),0)+1);
		}
		for(Character c : a.keySet()){
			if(a.get(c)>=10){
				b.put(c,a.get(c));
			}
		}
		for(Character c : a.keySet()){
			if (!b.containsKey(c)) {
				if(c==' '){
					out.print("_[" + a.get(c) + "]");
				}
				else{
					out.print(c+"[" + a.get(c)+"]");
				}
			}
		}
		out.print(";");
		for(Character c : b.keySet()){
			if(c==' '){
				out.print("_[" + b.get(c) + "]");
			}
			else{
				out.print(c+"[" + b.get(c)+"]");
			}
		}
		out.println();
        f.close();
    }
}
