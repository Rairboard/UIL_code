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

public class josefa {
    public static void main(String[] args) throws Exception {
        new josefa().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("josefa").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt();
			String ln = Integer.toString(Math.abs(n),2);
			while(ln.length()<8){
				ln = "0" + ln;
			}
			out.print(n+" = ");
			if(n>=0){
				out.println(ln);
			}
			else{
				String s = ln.substring(0,ln.lastIndexOf("1"));
				for (int i = 0; i < s.length(); i++) {
					out.print(s.charAt(i)=='0'?1:0);
				}
				out.println(ln.substring(ln.lastIndexOf("1")));
			}
        }
        f.close();
    }
}
