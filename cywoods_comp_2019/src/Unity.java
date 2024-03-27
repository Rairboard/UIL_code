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

public class Unity {
    public static void main(String[] args) throws Exception {
        new Unity().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Unity").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        boolean solved = true;
        while (times-- > 0) {
            if(f.nextLine().matches(".*Maxwell: Regarding the Unity update\\.\\.\\..*")){
                solved = false;
            }
        }
        out.println(!solved?"“Song failed. Everyone gets an F in their stocking.":"Song passed! Everyone gets an A for Christmas.");
        f.close();
    }
}
