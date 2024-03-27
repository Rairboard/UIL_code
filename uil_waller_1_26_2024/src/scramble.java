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

public class scramble {
    HashSet<String> ts;
    public static void main(String[] args) throws Exception {
        new scramble().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("scramble").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String ln = f.nextLine();
            ts = new HashSet<>();
            permu(ln,"");
            List<String> al = new ArrayList<>(ts);
            Collections.sort(al);
            for(int i = al.size()-1;i>-1 && i > al.size() - 6;i--){
                out.print(al.get(i) + " ");
            }
            out.println();
        }
        f.close();
    }
    public void permu(String cur, String goal){
        if(cur.length() == 0){
            ts.add(goal);
        }
        else{
            for (int i = 0; i < cur.length(); i++) {
                permu(cur.substring(0,i) + cur.substring(i+1),goal + cur.charAt(i));
            }
        }
    }
}
