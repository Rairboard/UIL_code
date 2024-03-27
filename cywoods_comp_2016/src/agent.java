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

public class agent {
    public static void main(String[] args) throws Exception {
        new agent().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("agent").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			 char[] c  = new StringBuilder(f.nextLine()).reverse().toString().toCharArray();
			for (int i = 0; i < c.length; i++) {
				if((i+1)%3==0){
					c[i] = (char)(Integer.toString(c[i],2).replaceAll("1","").length() + 65);
				}
			}
			out.println(new String(c));
        }
        f.close();
    }
}
