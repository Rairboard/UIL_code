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

public class prob16 {
    public static void main(String[] args) throws Exception {
        new prob16().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("prob16").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
		String[] ln = f.nextLine().split("\\s+");
		int[] cnt = new int[2];
		List<String> al = new ArrayList<>();
		for (int i = 0; i < ln.length; i++) {
			String s = ln[i];
			if (s.equalsIgnoreCase("is") || s.equalsIgnoreCase("had")) {
				if(s.equalsIgnoreCase("is") && cnt[0] < 2){
					out.print(s+" ");
					cnt[0]++;
				}
				if(s.equalsIgnoreCase("had")&&cnt[1]<2){
					out.print(s+" ");
					cnt[1]++;
				}
			}
			else if(!al.contains(s)){
				out.print(s+" ");
			}
			al.add(s);
		}
        f.close();
    }
}
