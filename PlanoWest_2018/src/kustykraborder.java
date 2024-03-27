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

public class kustykraborder {
    public static void main(String[] args) throws Exception {
        new kustykraborder().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("kustykraborder").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int times = f.nextInt();
            f.nextLine();
            o: for (int asdf = 1; asdf <= times; asdf++) {
                int n = f.nextInt();
                double m = f.nextDouble();
                int c = f.nextInt();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            if(i + j + k > n || i + j + k < n) continue;
                            if(k < i-j) continue;
                            if(i * 1.25 + j + k * 2 == m){
                                out.printf("%d krabby patties, %d coral bits, %d kelp shakes\n",i,j,k);
                                continue o;
                            }
                        }
                    }
                }
            }
        }
        f.close();
    }
}
