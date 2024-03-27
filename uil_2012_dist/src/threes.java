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

public class threes {
    public static void main(String[] args) throws Exception {
        new threes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("threes").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            long n = f.nextLong(), m = 1;
            while(true){
                long N = n * m;
                String check = Long.toString(N);
                boolean pass = true;
                for (int i = 0; i < 10; i++) {
                    if(i!=3 && i!=0){
                        if(check.contains(i+"")){
                            pass = false;
                            break;
                        }
                    }
                }
                if(pass){
                    out.println(N);
                    break;
                }
                m++;
            }
        }
        f.close();
    }
}
