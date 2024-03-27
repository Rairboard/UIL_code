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

public class message {
    public static void main(String[] args) throws Exception {
        new message().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("message").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int l =f.nextInt();
            f.nextLine();
            String[] ln = f.nextLine().split("[\\s\\.\\,]+");
            for (int i = 0; i < ln.length; i++) {
                if(!ln[i].isEmpty()&&ln[i].length()==l){
                    out.print(ln[i]+" ");
                }
            }
            out.println();
        }
        f.close();
    }
}
