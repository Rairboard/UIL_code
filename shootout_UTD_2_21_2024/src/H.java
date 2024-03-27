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

public class H {
    public static void main(String[] args) throws Exception {
        new H().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("H").toLowerCase() + ".txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine();
			int space = (ln.length() * 2 - 1)/2;
			for (int i = 0; i < ln.length(); i++) {
				for(int j = 0; j < space;j++){
                    out.print(" ");
                }
                space--;
				for (int j = 0; j <= i; j++) {
					out.print(ln.charAt(i) +" ");
				}
				out.println();
			}

        }
        f.close();
    }
}
