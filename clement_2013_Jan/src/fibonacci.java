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

public class fibonacci {
    public static void main(String[] args) throws Exception {
        new fibonacci().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("fibonacci").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int d = f.nextInt();
			List<Integer> al = new ArrayList<>();
			al.add(1);
			al.add(1);
			while(al.size()<d){
				al.add(al.get(al.size()-1)+al.get(al.size()-2));
			}
			long sum = 0;
			for (int i = 0; i < d; i++) {
				sum+=al.get(i);
			}
			out.println(sum);
        }
        f.close();
    }
}
