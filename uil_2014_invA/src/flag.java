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

public class flag {
    public static void main(String[] args) throws Exception {
        new flag().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("flag").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt(), lines = f.nextInt();
			if(f.hasNext()) f.nextLine();
			for (int i = 0; i < lines; i++) {
				out.print("G".repeat(n/3));
				if(i==0 || i == lines-1){
					out.print("-".repeat(n/3));
				}
				else{
					out.print(" ".repeat(n/3));
				}
				out.println("R".repeat(n/3));
			}
			out.println();
        }
        f.close();
    }
}
