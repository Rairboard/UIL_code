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

public class triangle {
    public static void main(String[] args) throws Exception {
        new triangle().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("triangle").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt();
			for (int i = 0; i < n-1; i++) {
				boolean print = false;
				for (int j = 0; j < i; j++) {
					out.print(" ");
					print = true;
				}
				if(print){
					out.println();
				}
				for (int j = 0; j < n-i; j++) {
					out.print("*");
				}
				out.println();
			}
        }
        f.close();
    }
}
