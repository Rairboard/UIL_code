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

public class prob14 {
    public static void main(String[] args) throws Exception {
        new prob14().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("prob14").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        List<BigInteger> al = new ArrayList<>();
		al.add(f.nextBigInteger());
		al.add(f.nextBigInteger());
		long n = f.nextLong();
		while(al.size()<n){
			BigInteger a = al.get(al.size()-1);
			BigInteger b = al.get(al.size()-2);
			al.add(a.add(b));
		}
		for (int i = 0; i < al.size(); i++) {
			out.print(al.get(i));
			if(i<al.size()-1){
				out.print(",");
			}
		}
        f.close();
    }
}
