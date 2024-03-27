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

public class janitor {
    public static void main(String[] args) throws Exception {
        new janitor().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("janitor").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			String s =f.next(), t = f.next(), ampm = f.next();
			if (ampm.equals("PM")) {
				out.println("Not Present");
			}else{

			}
        }
        f.close();
    }
}
