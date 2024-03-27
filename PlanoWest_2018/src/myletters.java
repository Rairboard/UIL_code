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

public class myletters {
    public static void main(String[] args) throws Exception {
        new myletters().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("myletters").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int times = f.nextInt();
            String[] ln = f.nextLine().trim().split("\\s+");
            String match = f.nextLine();
            boolean found = true;
            for (int i = 0; i < ln.length; i++) {
                if(!match.contains(ln[i])){
                    found = false;
                    break;
                }
                match = match.substring(0,match.indexOf(ln[i])) + match.substring(match.indexOf(ln[i])+ln[i].length());
            }
            out.println(found?"Potentially!":"No, No, No!!!");
        }
        f.close();
    }
}
