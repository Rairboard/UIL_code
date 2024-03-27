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

public class almostprime {
    public static void main(String[] args) throws Exception {
        new almostprime().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("almostprime.dat"));
        //Scanner f = new Scanner(System.in);
		List<Integer> prime = new ArrayList<>();
		for (int i = 1; i <= Integer.MAX_VALUE && prime.size()<40 ; i++) {
			int cnt = 0;
			for (int j = 1; j <= i; j++) {
				if(i%j==0){
					cnt++;
				}
			}
			if(cnt==3){
				prime.add(i);
			}
		}
        while(f.hasNext()){
			out.println(prime.get(f.nextInt()-1));
		}
        f.close();
    }
}
