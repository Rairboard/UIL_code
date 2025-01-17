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

public class richard {
    HashSet<String>hs;
    public static void main(String[] args) throws Exception {
        new richard().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("richard").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int index = f.nextInt();
            f.nextLine();
            String ln =f.nextLine().trim();
            hs = new HashSet<>();
            permu(ln,"");
            List<String> al = new ArrayList<>(hs);
            Collections.sort(al);
            out.println("Password #" + asdf + ": " + al.get(index-1));
        }
        f.close();
    }
    public void permu(String orig, String cur){
        if(orig.length()==0){
            hs.add(cur);
        }
        else{
            for (int i = 0; i < orig.length(); i++) {
                permu(orig.substring(0,i) + orig.substring(i+1), cur + orig.charAt(i));
            }
        }
    }
}
