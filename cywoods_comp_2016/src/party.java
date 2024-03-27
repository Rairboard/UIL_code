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

public class party {
    public static void main(String[] args) throws Exception {
        new party().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("party").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			out.println(f.nextDouble()-f.nextDouble()<=0 ? "Dance On!":"BOO!");
        }
        f.close();
    }
}
