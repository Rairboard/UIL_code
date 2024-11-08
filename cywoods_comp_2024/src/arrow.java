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

public class arrow {
    public static void main(String[] args) throws Exception {
        new arrow().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("arrowJ").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt();
			int space = (n/2+1) * 2 + (n - (n/2+1) - 2);
            int mid = 1;
			String print = ""+ 1;
            out.println(" ".repeat(space) + print);
            space-=3;
			for(int i = 2; i <= n/2+1;i++){
                print = i + " " + print;
                out.println(" ".repeat(space) + print + " ".repeat(mid) + new StringBuilder(print).reverse().toString());
                space-=3;
                mid+=2;
			}
            space+=6;
            mid-=4;
            for(int i = n/2;i>=2;i--){
                print = print.substring(print.indexOf(" ")+1);
                out.println(" ".repeat(space) + print + " ".repeat(mid) + new StringBuilder(print).reverse().toString());
                space+=3;
                mid-=2;
            }
            out.println(" ".repeat(space) + 1);
            out.println("*".repeat(10));
        }
        f.close();
    }
}
