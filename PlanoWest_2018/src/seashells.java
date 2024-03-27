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

public class seashells {
    public static void main(String[] args) throws Exception {
        new seashells().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("seashells").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int b = f.nextInt(), r = f.nextInt();
            if(b + r < 10 || b % 2 != 1 || r % 2!=0){
                out.println("CLOSED");
            }
            else{
                out.println("OPEN");
            }
        }
        f.close();
    }
}
