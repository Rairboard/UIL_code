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

public class more {
    public static void main(String[] args) throws Exception {
        new more().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("more").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt();
			f.nextLine();
			Box[] boxes = new Box[n];
			boolean[] used = new boolean[n];
			for (int i = 0; i < n; i++) {
				int[] ar = Arrays.stream(f.next().trim().split("x")).mapToInt(Integer::parseInt).toArray();
				Arrays.sort(ar);
				boxes[i] = new Box(ar);
			}
			Arrays.sort(boxes);
//			for(Box b : boxes){
//				out.println(Arrays.toString(b.size));
//			}
			if(f.hasNext()) f.nextLine();
			int nestedBox = 0;
			for(int i = boxes.length-1;i>-1;i--){
				Box prev = boxes[i];
				if(used[i]) continue;
				used[i] = true;
				for(int j = i-1;j>-1;j--){
					if(used[j]) continue;
					if(compare(boxes[j].size,prev.size) < 0){
						used[j] = true;
						prev = boxes[j];
					}
				}
				nestedBox++;
			}
			out.println(nestedBox);
        }
        f.close();
    }
	class Box implements Comparable<Box>{
		int[] size;
		public Box(int[] b){
			this.size = b;
		}
		public int compareTo(Box o){
			return compare(size, o.size);
		}
	}
	public int compare(int[] a, int[] b){
		for(int i = 0;i < a.length;i++){
			if(a[i] < b[i]){
				return -1;
			}
			else if(a[i]>b[i]){
				return 1;
			}
			else{
				return 0;
			}
		}
		return 0;
	}
}
