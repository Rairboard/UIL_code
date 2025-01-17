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

public class aliases {
    public static void main(String[] args) throws Exception {
        new aliases().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("aliases").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String[] ln = f.nextLine().trim().split(",\\s+");
			for(int i = 0;i < ln.length-1;i++){
				if (ln[i].equals(ln[ln.length - 1])) {
					out.println((int)(Math.pow(i+1,2) + Math.pow(ln[ln.length-1].length(),2)));
					break;
				}
			}
        }
        f.close();
    }
}
