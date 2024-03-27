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

public class prob08 {
    public static void main(String[] args) throws Exception {
        new prob08().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("prob08").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        String[] w = "ZERO ONE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE TEN ELEVEN TWELVE".split(" ");
		Map<String,Integer> tm = new TreeMap<>();
		int[] ar = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		for (int i = 0; i < ar.length - 1; i++) {
			String a = w[ar[i]];
			Map<String,Integer> cnt = new HashMap<>();
			for (int j = 0; j < a.length(); j++) {
				cnt.put(a.substring(j,j+1),cnt.getOrDefault(a.substring(j,j+1),0)+1);
			}
			for(String s : cnt.keySet()){
				if (tm.containsKey(s)) {
					tm.put(s,Math.max(tm.get(s),cnt.get(s)));
				}
				else{
					tm.put(s,cnt.get(s));
				}
			}
		}
		for (int i = 0; i < ar.length - 1; i++) {
			out.print(ar[i]);
			if(i < ar.length-2){
				out.print(" ");
			}
		}
		out.print(". ");
		for(String s : tm.keySet()){
			for (int i = 0; i < tm.get(s); i++) {
				out.print(s+" ");
			}
		}
        f.close();
    }
}
