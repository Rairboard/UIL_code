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

public class Written {
    public static void main(String[] args) throws Exception {
        new Written().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Written").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int score = f.nextInt();
            boolean solved = false;
            for (int skipped = 0; skipped <= 40; skipped++) {
                for (int wrong = 0; wrong <= 40 - skipped; wrong++) {
                    for (int right = 0; right <= 40 - wrong - skipped; right++) {
                        if(right * 6 - wrong * 2==score){
                            solved = true;
                            break;
                        }
                    }
                }
            }
            out.println(solved?"Possible":"Impossible");
        }
        f.close();
    }
}
