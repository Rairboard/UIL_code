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

public class lottery {
    public static void main(String[] args) throws Exception {
        new lottery().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("lottery").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long a = f.nextLong(), b = f.nextLong();
            long money = 0;
            if(a==0 && b%10==0){
                money+=10;
            }
            else if(b==0 && a%10==0){
                money+=10;
            }
            else{
                while(a > 0 && b >0){
                    if(a%10==b%10){
                        money+=10;
                    }
                    a/=10;
                    b/=10;
                }
            }
            out.println("$" + money);
        }
        f.close();
    }
}
