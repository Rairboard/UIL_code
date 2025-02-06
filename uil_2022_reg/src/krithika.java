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

public class krithika {
    public static void main(String[] args) throws Exception {
        new krithika().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("krithika").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String[] num = new String[10];
        num[0] = "***" +
                " _ " +
                "| |" +
                "|_|" +
                "   " +
                "***";
        num[1] = "***" +
                "   " +
                "  |" +
                "  |" +
                "   " +
                "***";
        num[2] = "***" +
                " _ " +
                " _|" +
                "|_ " +
                "   " +
                "***";
        num[3] = "***" +
                " _ " +
                " _|" +
                " _|" +
                "   " +
                "***";
        num[4] = "***" +
                 "   " +
                 "|_|" +
                 "  |" +
                 "   " +
                 "***";
        num[5]  ="***" +
                " _ " +
                "|_ " +
                " _|" +
                "   " +
                "***";
        num[6] = "***" +
                " _ " +
                "|_ " +
                "|_|" +
                "   " +
                "***";
        num[7] = "***" +
                " _ " +
                "  |" +
                "  |" +
                "   " +
                "***";
        num[8] = "***" +
                " _ " +
                "|_|" +
                "|_|" +
                "   " +
                "***";
        num[9] = "***" +
                " _ " +
                "|_|" +
                "  |" +
                "   " +
                "***";
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();

        }
        f.close();
    }
}
