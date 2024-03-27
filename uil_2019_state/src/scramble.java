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

public class scramble {
    public static void main(String[] args) throws Exception {
        new scramble().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("scramble").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine();
			if(ln.contains("m")){
				out.println("milk");
			} else if (ln.contains("g")) {
				out.println("eggs");
			}
			else{
				out.println("wheat");
			}
        }
        f.close();
    }
}
