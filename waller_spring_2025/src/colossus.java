import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class colossus {
    public static void main(String[] args) throws Exception {
        new colossus().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("colossus").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            BigInteger  b = f.nextBigInteger();
            if(b.compareTo(BigInteger.valueOf(10000))>0){
                out.println("Lunk Alarm!!");
            }
            else out.println("Hulk here we come.");
        }
        f.close();
    }
}
