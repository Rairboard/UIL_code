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

public class cyclist {
    public static void main(String[] args) throws Exception {
        new cyclist().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cyclist").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        List<String> w = new ArrayList<>(Arrays.asList("one,two,three,four,five,six,seven,eight,nine".split(",")));
        List<String> al = new ArrayList<>();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            al.add(w.get(n-1));
            if(n==9){
                Collections.sort(al, (a,b) ->{
                    return w.indexOf(a) - w.indexOf(b);
                });
                out.print("[");
                for (int i = 0; i < al.size(); i++) {
                    out.print(al.get(i));
                    if(i<al.size()-1){
                        out.print(",");
                    }
                }
                out.println("]");
                al = new ArrayList<>();
            }
        }
        f.close();
    }
}
