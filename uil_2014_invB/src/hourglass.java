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

public class hourglass {
    public static void main(String[] args) throws Exception {
        new hourglass().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hourglass").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            for (int i = 0; i < n; i+=2) {
                out.println("*".repeat(n-i));
            }
            for(int i = 3;i<=n;i+=2){
                out.println("*".repeat(i));
            }
        }
        f.close();
    }
}
