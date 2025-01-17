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

public class palindromes {
    public static void main(String[] args) throws Exception {
        new palindromes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("palindromes").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine().trim();
            int max = 0;
			for (int i = 0; i < ln.length(); i++) {
				for(int j = i  +1;j <= ln.length();j++){
                        String sub = ln.substring(i,j).toLowerCase().replaceAll("[x \\p{Punct}0-9 ]","");
                        if(sub.equals(new StringBuilder(sub).reverse().toString())){
                        	max = Math.max(max, sub.length());
                        }
				}
			}
            out.println(max);
        }
        f.close();
    }
}
