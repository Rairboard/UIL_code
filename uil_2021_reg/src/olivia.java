import javax.management.ValueExp;
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

public class olivia {
    public static void main(String[] args) throws Exception {
        new olivia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("olivia").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long r = f.nextLong(), c =f.nextLong(), k = f.nextLong();
            long row =0,col=0;
            for(long i = 1;i<=r;i++){
                if(i * c >= k && k % i ==0 ){
                    row = i;
                    col = k / i;
                    break;
                }
            }
            long N = row * col;
            if(col >= r){
                N+=Math.abs(row-col) * row;
            }
            out.println("Case #" + asdf + ": " + N);
        }
        f.close();
    }
}
