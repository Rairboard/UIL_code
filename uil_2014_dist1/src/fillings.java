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

public class fillings {
    public static void main(String[] args) throws Exception {
        new fillings().run();
    }

    public void run() throws Exception {
        int[] fact = new int[11];
        fact[0] = 1;
        for(int i = 1;i<=10;i++) {
            fact[i] = i * fact[i - 1];
        }
        Scanner f = new Scanner(new File(("fillings").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt(), m = f.nextInt();
            out.println(fact[m] / fact[m-n]);
        }
        f.close();
    }
}
