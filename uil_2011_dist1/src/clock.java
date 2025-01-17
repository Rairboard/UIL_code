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

public class clock {
    public static void main(String[] args) throws Exception {
        new clock().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("clock").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().split(":");
            int hour = Integer.parseInt(ln[0]);
            int minutes = Integer.parseInt(ln[1]);
            if(minutes==0){
                if(hour==12 ){
                    out.println(ln[0] + ":00");
                }
                else{
                    out.println(12 - hour + ":00");
                }
            }
            else{
                hour = (12 + (12-hour-1)) % 12;
                minutes = 60 - minutes;
                if(hour==0){
                    hour = 12;
                }
                out.printf("%d:%02d\n", hour, minutes);
            }
        }
        f.close();
    }
}
