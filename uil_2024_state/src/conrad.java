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

public class conrad {
    public static void main(String[] args) throws Exception {
        new conrad().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("conrad").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine();
            int diff = Math.abs(ln.charAt(0) - ln.charAt(1));
            boolean good = true;
            for (int i = 2; i < ln.length()-1; i++) {
                int d = Math.abs(ln.charAt(i) - ln.charAt(i+1));
                if (diff != d) {
                    good = false;
                    break;
                }
            }
            if(good){
                out.println(ln);
            }
            else{
                out.println("BAD!!!");
            }
        }
        f.close();
    }
}
