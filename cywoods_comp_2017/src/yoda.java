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

public class yoda {
    public static void main(String[] args) throws Exception {
        new yoda().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("yoda").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		while(f.hasNext()){
			String[] ln = f.nextLine().toLowerCase().split("\\s+");
			for (int i = 2; i < ln.length; i++) {
				if(i==2){
					out.print(ln[i].substring(0,1).toUpperCase() + ln[i].substring(1));
				}
				else{
					out.print(ln[i]);
				}
				out.print(i<ln.length-1?" ":", ");
			}
			for (int i = 0; i < 2; i++) {
				out.print(ln[i] + " ");
			}
			out.println();
		}
        f.close();
    }
}
