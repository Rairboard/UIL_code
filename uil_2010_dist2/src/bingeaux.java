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

public class bingeaux {
    public static void main(String[] args) throws Exception {
        new bingeaux().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bingeaux").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine().trim();
            TreeSet<String> variant =new TreeSet<>();
            for (int i = 0; i < ln.length()-1; i++) {
                if (ln.substring(i, i + 2).equals("ph")) {
                    variant.add(ln.substring(0,i) + "f" + ln.substring(i+2));
                }
            }
            for (int i = 0; i < ln.length()-2; i++) {
                if (ln.substring(i, i + 2).equals("ai")) {
                    variant.add(ln.substring(0,i) + "ay" + ln.substring(i+2));
                }
            }
            for(int i = 0;i < ln.length();i++){
                int j = i+1;
                while(j< ln.length() && ln.charAt(j) == ln.charAt(i)) j++;
                if(j-i==2){
                    variant.add(ln.substring(0,i+1) + ln.substring(j));
                    i = j-1;
                }
                else if(j-i > 2){
                    i = j-1;
                }
            }
            if(ln.charAt(ln.length()-1)=='o'){
                variant.add(ln.substring(0,ln.length()-1) + "eaux");
            }
            out.println(ln);
            for(String s : variant){
                out.println(s);
            }
        }
        f.close();
    }
}
