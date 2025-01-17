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

public class screen {
    public static void main(String[] args) throws Exception {
        new screen().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("screen").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int c = f.nextInt(), r = f.nextInt();
            if(f.hasNext()) f.nextLine();
            String[] ln = f.nextLine().trim().split("\\s+");
            int i = 0;
            List<String> al = new ArrayList<>();
            while(i < ln.length){
                List<String> pr = new ArrayList<>();
                int cnt = 0;
                int j = i;
                while(j < ln.length && cnt + ln[j].length() <= c){
                    cnt+=ln[j].length();
                    pr.add(ln[j]);
                    j++;
                }
                if(j == i && ln[i].length() > c){
                    cnt = ln[i].substring(0,c).length();
                    pr.add(ln[i].substring(0,c));
                    ln[i] = ln[i].substring(c);
                }
                int space = pr.size() - 1;
                while( cnt  + space > c){
                    space--;
                    cnt -=pr.getLast().length();
                    pr.removeLast();
                    j--;
                }
                String print = "";
                for(String s : pr){
                    print += s + " ";
                }
                print = print.trim();
                if(print.length() == c){
                    al.add(print);
                }
                else{
                    int before = (c-print.length()) / 2;
                    String s = "";
                    for (int k = 0; k < before; k++) {
                        s += " ";
                    }
                    s += print;
                    while( s.length() + 1 <= c){
                        s += " ";
                    }
                    al.add(s);
                }
                i = j;
            }
            if(al.size() > r){
                out.println("Title not compatible with size.");
                continue;
            }
            int lines = (r-al.size()) /2;
            out.println("#".repeat(c+2));
            for (int j = 0; j < lines; j++) {
                out.println("#"  + " ".repeat(c) + "#");
            }
            for(String s : al){
                out.println("#" + s + "#");
            }
            for (int j = 0; j < r - lines - al.size(); j++) {
                out.println("#" +  " ".repeat(c) + "#");
            }
            out.println("#".repeat(c+2));
        }
        f.close();
    }
}
