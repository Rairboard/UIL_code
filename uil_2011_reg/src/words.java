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

public class words {
    public static void main(String[] args) throws Exception {
        new words().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("words").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        List<String> al = new ArrayList<>();
		int n = f.nextInt();
		f.nextLine();
		for (int i = 0; i < n; i++) {
			al.addAll(Arrays.asList(f.nextLine().trim().split("\\s+")));
		}
		n = f.nextInt();
		f.nextLine();
		for (int i = 0; i < n; i++) {
			String[] ln = f.nextLine().trim().split("\\s+");
			int length = Integer.parseInt(ln[0]);
			String end = ln[1];
			TreeSet<String> ts = new TreeSet<>();
			for(String s : al){
				if (s.length() == length && s.matches(".*" + end)) {
					ts.add(s);
				}
			}
			if(ts.size()==0){
				out.println("NONE");
			}
			else{
				for(String s : ts){
					out.println(s);
				}
			}
			out.println();
		}
        f.close();
    }
}
