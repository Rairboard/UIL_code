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

public class flexjbox {
    public static void main(String[] args) throws Exception {
        new flexjbox().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("flexjbox.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			char[][] m = new char[f.nextInt()][f.nextInt()];
			for (int i = 0; i < m.length; i++) {
				Arrays.fill(m[i],'*');
			}
			m[f.nextInt()][f.nextInt()]='J';
			for(char[] c : m){
				out.println(c);
			}
			out.println();
        }
        f.close();
    }
}
