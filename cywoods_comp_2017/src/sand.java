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

public class sand {
    public static void main(String[] args) throws Exception {
        new sand().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sand").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n = f.nextInt();
			f.nextLine();
			for (int i = 0; i < n; i++) {
				if(f.nextLine().toLowerCase().replaceAll("\\s+","").contains("sand")){
					out.println("I HATE SAND!!!");
				}else{
					out.println("Here everything is soft and smooth.");
				}
			}
			out.println();
        }
        f.close();
    }
}
