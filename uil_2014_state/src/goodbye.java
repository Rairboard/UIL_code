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

public class goodbye {
    public static void main(String[] args) throws Exception {
        new goodbye().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("goodbye").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine().trim().toLowerCase();
			int cnt = 0;
			for (int i = 0; i < ln.length()-6; i++) {
				if (ln.substring(i, i + 7).equals("goodbye")) {
					cnt++;
					i+=6;
				}
			}
			out.println(cnt);
        }
        f.close();
    }
}
