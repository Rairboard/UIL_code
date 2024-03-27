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

public class gems {
    public static void main(String[] args) throws Exception {
        new gems().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("gems").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n = f.nextInt();
			for (int i = 0; i <= n/2; i++) {
				for (int j = 0; j < n/2-i; j++) {
					out.print(" ");
				}
				for (int j = 0; j <= i; j++) {
					out.print("$");
				}
				for (int j = 0; j < i; j++) {
					out.print("$");
				}
				out.println();
			}
			for (int i = 0; i < n/2; i++) {
				for (int j = 0; j <= i; j++) {
					out.print(" ");
				}
				for (int j = 0; j < n/2 - i; j++) {
					out.print("$");
				}
				for (int j = 0; j < n / 2 - i - 1; j++) {
					out.print("$");
				}
				out.println();
			}
			out.println();
        }
        f.close();
    }
}
