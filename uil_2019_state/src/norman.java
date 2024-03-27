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

public class norman {
    public static void main(String[] args) throws Exception {
        new norman().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("norman").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			long n = f.nextLong();
			if(n==13){
				out.println("BAD LUCK");
			}
			else{
				out.println((n & 1)==0?"EVEN":"ODD");
			}
        }
        f.close();
    }
}
