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

public class roman {
    public static void main(String[] args) throws Exception {
        new roman().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("roman").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        String roman = "IVXLCDM";
        int[] val = {1,5,10,50,100,500,1000};
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine();
            out.print(ln + " = ");
            int sum = 0;
            for (int i = ln.length()-1;i>-1;i--) {
                if(i-1 >=0 && val[roman.indexOf(ln.charAt(i-1))] < val[roman.indexOf(ln.charAt(i))]){
                    int j = i-1;
                    int cnt = 1;
                    while (j - 1 > -1 && ln.charAt(j) == ln.charAt(j - 1)) {
                        j--;
                        cnt++;
                    }
                    sum+=val[roman.indexOf(ln.charAt(i))] - val[roman.indexOf(ln.charAt(i-1))] * cnt;
                    i = j;
                }
                else{
                    sum+=val[roman.indexOf(ln.charAt(i))];
                }
            }
            out.println(sum);
        }
        f.close();
    }
}
