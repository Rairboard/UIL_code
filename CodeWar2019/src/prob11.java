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

public class prob11 {
    public static void main(String[] args) throws Exception {
        new prob11().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("prob11").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int w = f.nextInt(), h = f.nextInt();
		if(f.hasNext()){
			f.nextLine();
		}
		Map<Integer,String> m = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < h; i++) {
			m.put(i,f.nextLine());
		}
		out.println(m);
		for(Integer i : m.keySet()){
			out.println(m.get(i));
		}
		for (int i = 0; i <= w; i++) {
			out.print(i%10);
		}
		out.println();
        f.close();
    }
}
