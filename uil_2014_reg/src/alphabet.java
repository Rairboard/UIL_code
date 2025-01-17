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

public class alphabet {
    public static void main(String[] args) throws Exception {
        new alphabet().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("alphabet").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String w = "";
        for (char c = 'A'; c <= 'Z'; c++) {
            w += c;
        }
        Map<Character, Character> m = new HashMap<>();
        for (int i = 0; i < w.length()/2; i++) {
            m.put(w.charAt(i),w.charAt(w.length()-i-1));
            m.put(w.charAt(w.length()-1-i), w.charAt(i));
        }
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine();
            int i = 0, j = ln.length() - 1;
            boolean match = true;
            while (i <= j) {
                if (m.get(ln.charAt(i)) != ln.charAt(j)) {
                    match = false;
                    break;
                }
                i++;
                j--;
            }
            if(match){
                out.println("YES");
            }
            else{
                out.println("NO");
            }
        }
        f.close();
    }
}
