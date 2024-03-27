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

public class adv55 {
    public static void main(String[] args) throws Exception {
        new adv55().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("adv55").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			char[] one = f.next().toLowerCase().toCharArray(), two = f.next().toLowerCase().toCharArray();
			Arrays.sort(one);
			Arrays.sort(two);
			if (new String(one).equals(new String(two))) {
				out.println("yes");
			}
			else{
				out.println("no");
			}
        }
        f.close();
    }
}
