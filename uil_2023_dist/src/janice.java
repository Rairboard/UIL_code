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

public class janice {
    public static void main(String[] args) throws Exception {
        new janice().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("janice").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String orig = f.nextLine();
			String decode = f.nextLine();
			List<Character> al = new ArrayList<>();
			for(char c = 'A';c<='Z';c++){
				al.add(c);
			}
			List<Character> alphabet = new ArrayList<>(al);
			int shift = -orig.charAt(0) + decode.charAt(0);
			Collections.rotate(al, shift);
//			out.println(alphabet);
//			out.println(al);
//			out.println(orig + "\n" + decode);
			String ln = f.nextLine();
			for(char c : ln.toCharArray()){
				if(c != ' '){
					out.print(al.get(alphabet.indexOf(c)));
				}
				else{
					out.print(c);
				}
			}
			out.println();
        }
        f.close();
    }
}
