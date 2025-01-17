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

public class cds {
    public static void main(String[] args) throws Exception {
        new cds().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cds").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            int cd = 0;
            int sum = 0;
            for (int i = 0; i <n ; i++) {
                int s = f.nextInt() *60 + f.nextInt();
                if(sum + s <= 1200){
                    sum+=s;
                }
                else{
                    cd++;
                    sum = s;
                }
            }
            if(sum>0){
                cd++;
            }
            out.println("PARTY #" + asdf + ": " + cd);
        }
        f.close();
    }
}
