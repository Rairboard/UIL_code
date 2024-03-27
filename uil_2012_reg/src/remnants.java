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

public class remnants {
    public static void main(String[] args) throws Exception {
        new remnants().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("remnants").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            out.println((int)Math.ceil(f.nextDouble() * 3 / 14));
        }
        f.close();
    }
}
