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

public class daniella {
    public static void main(String[] args) throws Exception {
        new daniella().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("daniella").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.next();
            int i = f.nextInt();
            while(!ln.isEmpty()){
                if(i>=ln.length()){
                    out.print(ln);
                    break;
                }
                else{
                    out.print(ln.substring(0,i) + "-");
                }
                ln = ln.substring(i);
            }
            out.println();
        }
        f.close();
    }
}
