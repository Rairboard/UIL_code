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

public class history {
    public static void main(String[] args) throws Exception {
        new history().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("history.in"));
        //Scanner f = new Scanner(System.in);
        String[] model = {"TO INFINITY AND BEYOND","inFIZZity","BUZZond","inferior model"};
        BigInteger[] speed = {BigInteger.valueOf(299792458).multiply(BigInteger.valueOf(31557600)),BigInteger.valueOf(299792458),BigInteger.valueOf(31557600),BigInteger.valueOf(1)};
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            BigInteger t = f.nextBigInteger();
            for (int i = 0; i < speed.length; i++) {
                if(t.mod(speed[i]) == BigInteger.ZERO){
                    out.println(model[i]);
                    break;
                }
            }
        }
        f.close();
    }
}
