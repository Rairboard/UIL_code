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

public class PlanktonChaser{
    public static void main(String[] args) throws Exception {
        new PlanktonChaser().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("PlanktonChaser").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			double to = f.nextDouble(), vp = f.nextDouble(), vs =f.nextDouble();
			double time = (to * vp) / (vs - vp);
			out.printf("%.7f\n",time);
        }
        f.close();
    }
}
