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

public class Scale {
    public static void main(String[] args) throws Exception {
        new Scale().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Scale").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);

		while(f.hasNext()){
			int[] ar = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int[] ret = new int[ar.length];
			for (int i = 0; i < ar.length; i++) {
				int left = 1, right = 1;
				if(i-1>=0){
					left = ar[i-1];
				}
				if(i+1<ar.length){
					right = ar[i+1];
				}
				ret[i]= ar[i] * left * right;
			}
			for (int i = 0; i < ret.length; i++) {
				out.print(ret[i] + " ");
			}
			out.println();
        }
        f.close();
    }
}
