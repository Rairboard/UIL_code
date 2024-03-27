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

public class jedi {
    public static void main(String[] args) throws Exception {
        new jedi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("jedi").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int r = f.nextInt(), g = f.nextInt(), b = f.nextInt();
			if(r>0){
				if(b>0){
					out.println("Get them!");
				}else{
					out.println("Protect the Federation!");
				}
			}else{
				out.println("Get them!");
			}
        }
        f.close();
    }
}
