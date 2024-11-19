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

public class tomas {
    public static void main(String[] args) throws Exception {
        new tomas().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("tomas").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			f.nextLine();
			String[] ln = f.nextLine().trim().split("\\s+");
			for (int i = 0; i < ln.length; i++) {
				int n = Integer.parseInt(ln[i].substring(0,1));
				int len = ln[i].length();
				if(n==0){
					out.print(" ".repeat(len));
				}
				else if(n==2){
					out.print("ABC".charAt((len-1)%3)+"".repeat(len));
				}
				else if(n==3){
					out.print("DEF".charAt((len-1)%3)+"".repeat(len));
				}
				else if(n==4){
					out.print("GHI".charAt((len-1)%3)+"".repeat(len));
				}
				else if(n==5){
					out.print("JKL".charAt((len-1)%3)+"".repeat(len));
				}
				else if(n==6){
					out.print("MNO".charAt((len-1)%3)+"".repeat(len));
				}
				else if(n==7){
					out.print("PQRS".charAt((len-1)%4)+"".repeat(len));
				}
				else if(n==8){
					out.print("TUV".charAt((len-1)%3)+"".repeat(len));
				}
				else if(n==9){
					out.print("WXYZ".charAt((len-1)%4)+"".repeat(len));
				}
			}
			out.println();
        }
        f.close();
    }
}
