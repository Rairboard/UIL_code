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

public class liberties {
    public static void main(String[] args) throws Exception {
        new liberties().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("liberties").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {

        }
        f.close();
    }
}
