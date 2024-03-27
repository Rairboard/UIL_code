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

public class weak {
    public static void main(String[] args) throws Exception {
        new weak().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("weak").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			String ln = f.nextLine();
            int digit = ln.replaceAll("[^0-9]","").length();
            int vowel = ln.toLowerCase().replaceAll("[^aeiou]","").length();
            int consonant = ln.toLowerCase().replaceAll("[aeiou]","").length();
            boolean consec = ln.toLowerCase().matches("[aeiou]{3,}");
            out.println(digit>=1 && vowel>=1 && consonant >=1  && consec&&ln.length()>=8?"VALID":"WEAK");
        }
        f.close();
    }
}
