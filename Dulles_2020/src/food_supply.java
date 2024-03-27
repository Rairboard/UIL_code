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

public class food_supply {
    public static void main(String[] args) throws Exception {
        new food_supply().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("food_supply.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int[] ar = Arrays.stream(f.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int sum = Arrays.stream(ar).sum()-ar[0];
            out.println(sum/ar[0]);
        }
        f.close();
    }
}