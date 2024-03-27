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

public class cryptopwatty {
    public static void main(String[] args) throws Exception {
        new cryptopwatty().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cryptopwatty").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int times = f.nextInt();
            f.nextLine();
            String key = f.nextLine();
            for (int asdf = 1; asdf <= times; asdf++) {
                String ln = f.nextLine();
                for (int i = 0; i < ln.length(); i++) {
                    if (ln.substring(i, i + 1).matches("\\w+")) {
                        out.print((char)('A'+key.indexOf(ln.charAt(i))));
                    }
                    else{
                        out.print(ln.charAt(i));
                    }
                }
                out.println();
            }
        }
        f.close();
    }
}
