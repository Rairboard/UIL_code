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

public class andrew {
    public static void main(String[] args) throws Exception {
        new andrew().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("andrew").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String[] w = "ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE".split(",");
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n = f.nextInt();
            for (int i = 1; i < 10; i++) {
                if(n%i==0){
                    out.print(w[i-1] +" ");
                }
            }
            out.println();
        }
        f.close();
    }
}
