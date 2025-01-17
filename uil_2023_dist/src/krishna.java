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

public class krishna {
    public static void main(String[] args) throws Exception {
        new krishna().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("krishna").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long a = f.nextLong(), b = f.nextLong();
            long sum = 0;
            for(long i = a;i<=b;i++){
                sum+= i * (i+1) / 2;
            }
            out.println(sum);
        }
        f.close();
    }
}
