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

public class festivals {
    public static void main(String[] args) throws Exception {
        new festivals().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("festivals").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n =f.nextInt();
			boolean normal = true;
			if ((n % 4 == 0 && n % 100 != 0) || (n % 400 == 0) || (n % 18==0)) {
				out.println(n + " is a leap year.");
				normal = false;
			}
			if(n % 18 ==0){
				normal = false;
				out.println(n + " is a Brimborion festival year.");
			}
			else if(n % 25 == 0){
				normal = false;
				out.println(n + " is a Narishkeit festival year.");
			}
			else{
				out.println(n + " is an ordinary year.");
			}
			out.println();
        }
        f.close();
    }
}
