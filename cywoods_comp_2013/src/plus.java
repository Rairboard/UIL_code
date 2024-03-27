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

public class plus {
    public static void main(String[] args) throws Exception {
        new plus().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("plus").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			long a = f.nextLong();
			String op = f.next();
			switch(op){
				case "plus":
					out.println(a + f.nextLong());break;
				case "minus":
					out.println(a - f.nextLong());break;
				case "divide":
					out.println(a/f.nextLong());break;
				case "times":
					out.println(a*f.nextLong());break;
			}
        }
        f.close();
    }
}
