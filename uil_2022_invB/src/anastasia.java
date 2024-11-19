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

public class anastasia {
    public static void main(String[] args) throws Exception {
        new anastasia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("anstasia").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        for(int i = 20;i>=0;i--){
			out.println("The square root of " + i * i + " is " + i + ".");
		}
    }
}
