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

public class poll {
    public static void main(String[] args) throws Exception {
        new poll().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("poll").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt();
			f.nextLine();
			Map<String,Integer> m = new HashMap<>();
			for (int i = 0; i < n; i++) {
				m.put(f.next(),f.next().equals("+")? 1 : -1);
			}
			int sum =0;
			for(String s : m.keySet()){
				sum+=m.get(s);
			}
			out.println(sum);
        }
        f.close();
    }
}
