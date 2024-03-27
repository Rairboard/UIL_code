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

public class WhatTheFrequencyVinny {
    public static void main(String[] args) throws Exception {
        new WhatTheFrequencyVinny().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("WhatTheFrequencyVinny").toLowerCase()));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt(), base = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			String[] ln = f.nextLine().split("\\s+");
			for (int i = 0; i < ln.length; i++) {
				out.print(Long.toString(Long.parseLong(ln[i],base),2)+" ");
			}
			out.println();
        }
        f.close();
    }
}
