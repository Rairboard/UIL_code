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

public class coins {
    public static void main(String[] args) throws Exception {
        new coins().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("coins.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n  =f.nextInt();
			Map<Integer,String> coin = new TreeMap<>();
			int[] dp = new int[n+1];
			for (int i = 0; i < n; i++) {
				String s = f.next();
				coin.put(f.nextInt(),s);
			}
			
        }
        f.close();
    }
}
