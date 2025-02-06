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

public class sasha {
    public static void main(String[] args) throws Exception {
        new sasha().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sasha").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt();
			f.nextLine();
			long[] height = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
			long[] left = new long[height.length];
			long[] right =new long[height.length];
			long max = 0;
			for (int i = 0; i < height.length; i++) {
				max = Math.max(max, height[i]);
				left[i] = max;
			}
			max = 0;
			for(int i = height.length-1;i>-1;i--){
				max = Math.max(max, height[i]);
				right[i] = max;
			}
			boolean bucket = false;
			long sum = 0;
			long total = 0;
			for (int i = 0; i < height.length; i++) {
				long top = Math.min(left[i],right[i]);
				if(top-height[i]>0){
					sum+=top-height[i];
					bucket = true;
				}
				else{
					if(sum>0) {
						total+=sum;
						out.print(sum + " ");
					}
					sum = 0;
				}
			}
			if(!bucket){
				out.println("Dry as a Bone...");
        	}
			else{
				if(sum > 0) {
					out.print(sum + " ");
					total+=sum;
				}
				out.println(total);
			}
    	}
		f.close();
	}
}
