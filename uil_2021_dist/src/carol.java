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

public class carol {
    public static void main(String[] args) throws Exception {
        new carol().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("carol").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String orig = f.nextLine();
			String ln = orig.toLowerCase();
			if (ln.equals(new StringBuilder(ln).reverse().toString())) {
				out.println("0 character(s) need to be added to convert "+orig+" into a palindrome.");
			}
			else{
				int save = -1;
				String reverse = new StringBuilder(orig.toLowerCase()).reverse().toString();
				for(int i = reverse.length()-1;i>-1;i--){
					String a = ln.substring(0,i+1);
					String b = reverse.substring(0,i+1);
					if(a.equals(new StringBuilder(a).reverse().toString())){
						save = ln.length()-i-1;
						break;
					}
					if (b.equals(new StringBuilder(b).reverse().toString())) {
						save = reverse.length()-i-1;
						break;
					}
				}
				if(save!=-1){
					out.print(save);
				}
				else{
					out.print(ln.length()-1);
				}
				out.println(" character(s) need to be added to convert " + orig + " into a palindrome.");
			}
        }
        f.close();
    }
}
