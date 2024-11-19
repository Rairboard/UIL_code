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

public class micha {
    public static void main(String[] args) throws Exception {
        new micha().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("micha").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        Map<String, Integer> count = new LinkedHashMap<>();
        for (int asdf = 1; asdf <= times; asdf++) {
            count.put(f.nextLine(),0);
        }
        List<String> words = new ArrayList<>(count.keySet());
        while(f.hasNext()){
            String ln = f.nextLine();
            for(String w : words){
                int cnt = 0;
                for(int i = 0;i < ln.length() - w.length() + 1;i++){
                    if (ln.substring(i, i + w.length()).equalsIgnoreCase(w)) {
                        cnt++;
                    }
                }
                count.put(w,count.get(w)+cnt);
            }
        }
        for(String w : count.keySet()){
            out.println("\"" + w + "\" " + count.get(w));
        }
        f.close();
    }
}
