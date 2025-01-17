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

public class patrick {
    public static void main(String[] args) throws Exception {
        new patrick().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("patrick").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()) {
            // 1 9
            String ln = f.next();
            int p = f.nextInt();
            if(f.hasNext())f.nextLine();
            for(int t = 1; t< p;t++){
                String tmp = "";
                for (int i = 0; i < ln.length(); i++) {
                    int j = i+1;
                    for(;j< ln.length();j++){
                        if (ln.charAt(i) != ln.charAt(j)) {
                            break;
                        }
                    }
                    tmp += (j-i) + ln.substring(i,i+1);
                    i = j-1;
                }
                ln = tmp;
            }
            out.println(ln);
        }
        f.close();
    }
}
