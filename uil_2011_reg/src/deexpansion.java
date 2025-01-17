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

public class deexpansion {
    public static void main(String[] args) throws Exception {
        new deexpansion().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("deexpansion").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String ln = f.nextLine();
        for (int i = 0; i < ln.length(); i+=16) {
            out.print(Integer.parseInt(ln.substring(i,i+16),2) + "  " );
        }
        f.close();
    }
}
