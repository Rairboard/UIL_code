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

public class bridgeposts {
    public static void main(String[] args) throws Exception {
        new bridgeposts().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bridgeposts").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int m =f.nextInt();
			f.nextLine();
			int[] depth = new int[m];
			for (int i = 0; i < m; i++) {
				depth[i] = f.nextInt();
			}
			int n = f.nextInt();
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int miles = f.nextInt();
				for (int j = 0; j < miles && j < m; j++) {
					min = Math.min(depth[j], min);
				}
			}
			out.println(min);
        }
        f.close();
    }
}
