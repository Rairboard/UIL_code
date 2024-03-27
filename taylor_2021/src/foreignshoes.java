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

public class foreignshoes {
    public static void main(String[] args) throws Exception {
        new foreignshoes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("foreignshoes.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			String s =f.next(), c = f.next();
			int size = f.nextInt();
			if(s.equals("Women")){
				out.println("Women " + (c.equals("UK")?"US " + (size+2):"UK " + (size-2)));
			}
			else{
				out.println("Men " + (c.equals("UK")?"US " + (size+1):"UK " + (size-1)));			}
        }
        f.close();
    }
}
