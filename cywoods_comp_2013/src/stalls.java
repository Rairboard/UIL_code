import java.sql.SQLOutput;
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

public class stalls {
    public static void main(String[] args) throws Exception {
        new stalls().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("stalls").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0){
			int c = f.nextInt(), e = f.nextInt(),passed = 0;
			int[] cow = new int[c];
			for (int i = 0; i < e; i++) {
				String events  = f.next();
				int l = f.nextInt()-1, r = f.nextInt()-1;
				if(events.equals("I")){
					int lim = f.nextInt();
					if(cow[r]-cow[l]+1<=lim){
						passed++;
					}
				}
				else{
					for(int j = l;j <= r;j++){
						cow[j] += j-l+1;
					}
					for(int j = r+1;j < cow.length;j++){
						cow[j] = cow[j-1];
					}
				}
			}
			out.println(passed);
        }
        f.close();
    }
}
