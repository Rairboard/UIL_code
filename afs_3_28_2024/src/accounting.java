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

public class accounting {
    public static void main(String[] args) throws Exception {
        new accounting().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("accounting").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		out.println("****.****.****.****.****.****.****.****.");
        out.println("       Transaction : Balance");
		double balance = 0;
        while(f.hasNext()){
			String ln= f.nextLine();
			double d = Double.parseDouble(ln.replaceAll("[,()$]",""));
			if(ln.matches("\\$\\(.*\\)")){
				balance+=-d;
			}
			else{
                balance+=d;
			}
            out.printf("%18s",ln);
            out.print(" : ");
            out.printf("$%(,.2f\n",balance);
        }
        out.println("****.****.****.****.****.****.****.****.");
        f.close();
    }
}
