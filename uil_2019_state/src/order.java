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

public class order {
    public static void main(String[] args) throws Exception {
        new order().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("order").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln= f.nextLine();
            int cnt=0;
            for (int i = 0; i < ln.length(); i++) {
                for (int j = i+1; j <= ln.length(); j++) {
                    String part  = ln.substring(i,j);
                    if(part.charAt(0) == part.charAt(part.length()-1)){
                        cnt++;
                    }
                }
            }
            out.println(cnt);
        }
        f.close();
    }
}
