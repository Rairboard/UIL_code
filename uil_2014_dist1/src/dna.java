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

public class dna {
    public static void main(String[] args) throws Exception {
        new dna().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dna").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String a = f.nextLine(),b  = f.nextLine();
			boolean good = true;
			for (int i = 0; i < a.length(); i++) {
				if ("ATCG".contains(a.charAt(i)+"")) {
					if(a.charAt(i)=='A' && b.charAt(i) != 'T'){
						good = false;
						break;
					}
					else if(a.charAt(i)=='T' && b.charAt(i) != 'A'){
						good = false;
						break;
					}
					else if(a.charAt(i)=='C' && b.charAt(i) != 'G'){
						good = false;
						break;
					}
					else if(a.charAt(i)=='G' && b.charAt(i) != 'C'){
						good = false;
						break;
					}
				}
				else{
					good = false;
					break;
				}
			}
			out.println(good?"GOOD":"BAD");
        }
        f.close();
    }
}
