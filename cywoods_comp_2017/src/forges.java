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

public class forges {
    public static void main(String[] args) throws Exception {
        new forges().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("forges").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n = f.nextInt();
			if(n<3){
				out.println(0);
			}
			else{
				List<BigInteger> al = new ArrayList<>();
				al.add(BigInteger.ONE);
				al.add(BigInteger.ONE);
				while(al.size()<n-2){
					al.add(al.get(al.size()-1).add(al.get(al.size()-2)));
				}
				BigInteger sum = BigInteger.ZERO;
				for (int i = 0; i < n - 2; i++) {
					sum = sum.add(al.get(i));
				}
				out.println(sum);
			}
        }
        f.close();
    }
}
