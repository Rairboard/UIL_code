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

public class miguel {
    public static void main(String[] args) throws Exception {
        new miguel().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("miguel").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine();
            char[] ar = ln.toCharArray();
            char[] words = ln.toLowerCase().replaceAll("[^a-zA-Z]+","").toCharArray();
            Arrays.sort(words);
            int index =0;
            for (int i = 0; i < ar.length; i++) {
                if(ar[i]>='a'&&ar[i]<='z'){
                    ar[i] = Character.toLowerCase(words[index++]);
                }
                else if(ar[i]>='A'&&ar[i]<='Z'){
                    ar[i] = Character.toUpperCase(words[index++]);
                }
            }
            out.println(new String(ar));
        }
        f.close();
    }
}
