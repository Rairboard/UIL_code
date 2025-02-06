import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class eva {
    public static void main(String[] args) throws Exception {
        new eva().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("eva").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            int space = (n * 2 - 1)/2;
            int star = 1;
            out.println("Start of Triangle #" + asdf);
            for(int i = 1;i<=n;i++){
                out.println(" ".repeat(space) + "*".repeat(star));
                space--;
                star+=2;
            }
            out.println("End of Triangle #" + asdf);
        }
        f.close();
    }
}
