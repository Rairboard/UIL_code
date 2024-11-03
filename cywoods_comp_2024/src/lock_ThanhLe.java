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

public class lock_ThanhLe {
    public static void main(String[] args) throws Exception {
        new lock_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("lock").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine().trim();
			Set<String> ts = new TreeSet<>();
			for(int i = 0;i < ln.length()-2;i++){
				if(ln.substring(i,i+3).equals(new StringBuilder(ln.substring(i,i+3)).reverse().toString())){
					ts.add(ln.substring(i,i+3));
				}
			}
			if(ts.isEmpty()){
				out.println("No Palindromes...");
			}
			else{
				ts.forEach(e -> out.print(e+" "));
				out.println();
			}
        }
        f.close();
    }
}
