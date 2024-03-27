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

public class strip {
    public static void main(String[] args) throws Exception {
        new strip().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("strip").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String ln = f.nextLine();
            int dis = 0, time = 1;
            boolean found = false;
            for(int i = ln.indexOf("T")-1;i>-1;i--){
                dis++;
                if(ln.charAt(i)=='C'){
                    found = true;
                    break;
                }
                if(ln.charAt(i)=='t'){
                    time+=3;
                }
                else{
                    time++;
                }
            }
            if(!found){
                dis+=ln.indexOf("T");
                time+=ln.indexOf("T");
                for(int i = ln.indexOf("T")+1;i<ln.length();i++){
                    dis++;
                    if(ln.charAt(i)=='C'){
                        break;
                    }
                    if(ln.charAt(i)=='t'){
                        time+=3;
                    }
                    else{
                        time++;
                    }
                }
            }
            double speed = (double)dis/time;
            out.print("Distance: " + dis + " meters\nTime: " + time + " seconds\nSpeed: ");
            if(speed - (int)speed==0){
                out.printf("%d meters per second\n",(int)speed);
            }
            else{
                String s = String.format("%.1f",speed - (int)speed);
                out.printf("%s meters per second\n",s.substring(1));
            }
            out.println();
        }
        f.close();
    }
}
