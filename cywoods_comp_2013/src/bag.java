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

public class bag {
    public static void main(String[] args) throws Exception {
        new bag().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bag").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        Map<String,Integer> m = new HashMap<>();
		int total = 0;
		for (int i = 0; i < 4; i++) {
			String a = f.next();
			int b = f.nextInt();
			m.put(a,b);
			total+=b;
		}
		int n = f.nextInt();
		while(n-->0){
			String s  =f.next();
			out.println(m.get(s) + "/" +total--);
			m.put(s,m.get(s)-1);
		}
        f.close();
    }
}
