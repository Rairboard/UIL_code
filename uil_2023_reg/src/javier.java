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

public class javier {
    public static void main(String[] args) throws Exception {
        new javier().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("javier").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int b1 = f.nextInt(), b2 = f.nextInt();
            char ch = f.next().charAt(0);
            char d = f.next().charAt(0);
            if(f.hasNext()) f.nextLine();
            if(d=='L'){
                if(b1<b2){
                    for(int i = b1;i<=b2;i++){
                        out.println((ch+"").repeat(i));
                    }
                }
                else{
                    for(int i = b1;i>=b2;i--){
                        out.println((ch+"").repeat(i));
                    }
                }
            }
            else{
                int max = Math.max(b1,b2);
                if(b1<b2){
                    for(int i = b1;i<=b2;i++){
                        out.println(" ".repeat(b2-i) + (ch+"").repeat(i));
                    }
                }
                else{
                    for(int i = b1;i>=b2;i--){
                        out.println(" ".repeat(b1-i) + (ch+"").repeat(i));
                    }
                }
            }
        }
        f.close();
    }
}
