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

public class mary {
    public static void main(String[] args) throws Exception {
        new mary().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("mary").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            out.println(f.nextLine());
        }
        f.close();
    }
}
