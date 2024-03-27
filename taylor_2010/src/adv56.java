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

public class adv56 {
    public static void main(String[] args) throws Exception {
        new adv56().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("adv56").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String[] ln = f.nextLine().split("[^0-9]");
			out.println(Integer.parseInt(ln[0])+Integer.parseInt(ln[1])==Integer.parseInt(ln[2])?"yes":"no");
        }
        f.close();
    }
}
