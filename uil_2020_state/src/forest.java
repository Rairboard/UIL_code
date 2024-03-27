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

public class forest {
    public static void main(String[] args) throws Exception {
        new forest().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("forest").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			String left = f.nextLine(), right = f.nextLine();
			if(left.replaceAll("[^o]","").length() > right.replaceAll("[^o]","").length()){
				out.println("BOULDERS: LEFT");
			}
			else{
				out.println("BOULDERS: RIGHT");
			}
			if(left.replaceAll("[^i]","").length() > right.replaceAll("[^i]","").length()){
				out.println("TREES: LEFT");
			}
			else{
				out.println("TREES: RIGHT");
			}
			if(left.replaceAll("[^m]","").length() > right.replaceAll("[^m]","").length()){
				out.println("BUSHES: LEFT");
			}
			else{
				out.println("BUSHES: RIGHT");
			}
			out.println();
		}
        f.close();
    }
}
