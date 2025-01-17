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

public class stickspolygon {
    public static void main(String[] args) throws Exception {
        new stickspolygon().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("stickspolygon").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt();
			int[] sides = new int[n];
			f.nextLine();
			for (int i = 0; i < n; i++) {
				sides[i] =f.nextInt();
			}
			Arrays.sort(sides);
			int maxsides = -1;
			int sum = sides[0] + sides[1];
			for (int i = 2; i < n; i++) {
				if(sum > sides[i]){
					maxsides = i+1;
				}
				sum+=sides[i];
			}
			out.println(maxsides);
        }
        f.close();
    }
}
