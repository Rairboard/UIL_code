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

public class priyanka {
    public static void main(String[] args) throws Exception {
        new priyanka().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("priyanka").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine();
			if(ln.matches("[AEIOU]+")){
				char[] ch = ln.toCharArray();
				Arrays.sort(ch);
				if (ln.equals(new StringBuilder(new String(ch)).reverse().toString())) {
					out.println("WOO-HOO " + ln);
				}
				else{
					out.println(new String(ch));
				}
			}
			else if(ln.matches("[^AEIOU]+")){
				char[] ch = ln.toCharArray();
				Arrays.sort(ch);
				if (ln.equals(new String(ch))) {
					out.println("WOO-HOO " + ln);
				}
				else{
					out.println(new String(ch));
				}
			}
			else{
				char[] vowel = ln.replaceAll("[^AEIOU]","").toCharArray();
				char[] consonant = ln.replaceAll("[AEIOU]","").toCharArray();
				Arrays.sort(vowel);
				Arrays.sort(consonant);
				String wooHooString = new StringBuilder(new String(vowel)).reverse() + new String(consonant);
				if (ln.equals(wooHooString)) {
					out.println("WOO-HOO " + ln);
				}
				else{
					out.println(wooHooString);
				}
			}
        }
        f.close();
    }
}
