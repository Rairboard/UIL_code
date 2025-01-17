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

public class bears {
    public static void main(String[] args) throws Exception {
        new bears().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bears").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int bear = 0;
            for(int i = 0;i < 10;i++){
                String ln = f.nextLine().trim();
                for (int j = 0; j < ln.length(); j++) {
                    if(ln.charAt(j)=='B'){
                        bear++;
                    }
                }
            }
            out.println(bear);
        }
        f.close();
    }
}
