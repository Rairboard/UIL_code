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

public class problems {
    public static void main(String[] args) throws Exception {
        new problems().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("problems").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);

        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine();
            int[] count = new int[3];
            String diff = "EMH";
            for (int i = 0; i < ln.length(); i++) {
                int index = diff.indexOf(ln.charAt(i));
                if(index>=0 && index <3){
                    count[index]++;
                }
            }
            int four = 0, three = 0;
            for(int i : count){
                if(i==3){
                    three++;
                }
                if(i==4){
                    four++;
                }
            }
            if(four==2 && three == 1){
                if(count[0] == 3){
                    out.println("easy");
                }
                else if(count[1] == 3){
                    out.println("medium");
                }
                else{
                    out.println("hard");
                }
            }
            else{
                out.println("Oh well, that's what I get for procrastinating");
            }
        }
        f.close();
    }
}
