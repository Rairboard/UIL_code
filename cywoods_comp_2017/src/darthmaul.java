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

public class darthmaul {
    public static void main(String[] args) throws Exception {
        new darthmaul().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("darthmaul").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			String s = f.nextLine();
			int[] ar = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer :: parseInt).toArray();
			Arrays.sort(ar);
//			out.println(Arrays.toString(ar));
			List<Integer> al = new ArrayList<>();
			if (s.equals("B")){
				for(int i = ar.length-1;i>=0;i--){
					if (al.size() > 0){
						if(i%2==0){
							al.add(al.size(),ar[i]);
						}else{
							al.add(0,ar[i]);
						}
					}else{
						al.add(ar[i]);
					}
				}
			}else{
				for(int i=0;i<ar.length;i++){
					if (al.size() > 00) {
						if(i%2==0){
							al.add(al.size(),ar[i]);
						}else{
							al.add(0,ar[i]);
						}
					}else{
						al.add(ar[i]);
					}
				}
			}
			for (int i = 0; i < al.size(); i++) {
				out.print(al.get(i) + " ");
			}
			out.println();
        }
        f.close();
    }
}
