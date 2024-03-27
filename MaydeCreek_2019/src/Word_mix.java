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

public class Word_mix {
    public static void main(String[] args) throws Exception {
        new Word_mix().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Word_mix").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        char[] first = f.next().toCharArray(), sec = f.next().toCharArray();
        int min = Math.min(first.length,sec.length);
        char[] ar = new char[min];
        for (int i = 0; i < min; i++) {
            if(i%2==0){
                if(i<first.length){
                    ar[i] =first[i];
                }
            }else{
                if(i<sec.length){
                    ar[i] = sec[i];
                }
            }
        }
        out.println(new String(ar));
        f.close();
    }
}
