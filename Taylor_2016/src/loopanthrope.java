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

public class loopanthrope {
    public static void main(String[] args) throws Exception {
        new loopanthrope().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("loopanthrope").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            String[] ln = f.nextLine().split(";");
            String para = ln[0].substring(ln[0].indexOf(" ")+1,ln[0].indexOf("="));
            String sign = ln[1].replaceAll("[^><=]","");
            int s = Integer.parseInt(ln[0].substring(ln[0].indexOf("=")+1));
            int e = Integer.parseInt(ln[1].substring(ln[1].indexOf(sign)+sign.length()));
            List<String> al = new ArrayList<>();
            for (int i = 0; i < n - 2; i++) {
                al.add(f.nextLine());
            }
            f.nextLine();
            out.println("//Unrolled");
            if (sign.equals("<")) {
                for (int i = s; i < e; i++) {
                    for (int j = 0; j < al.size(); j++) {
                        out.println(al.get(j).replaceAll("(\\W)("+para+")(\\W)","$1" + i + "$3"));
                    }
                }
            } else if (sign.equals("<=")) {
                for (int i = s; i <= e; i++) {
                    for (int j = 0; j < al.size(); j++) {
                        out.println(al.get(j).replaceAll("(\\W)("+para+")(\\W)","$1" + i + "$3"));
                    }
                }
            } else if (sign.equals(">")) {
                for(int i = s;i > e;i++){
                    for (int j = 0; j < al.size(); j++) {
                        out.println(al.get(j).replaceAll("(\\W)("+para+")(\\W)","$1" + i + "$3"));
                    }
                }
            } else if (sign.equals(">=")) {
                for(int i = s; i >= e;i++){
                    for (int j = 0; j < al.size(); j++) {
                        out.println(al.get(j).replaceAll("(\\W)("+para+")(\\W)","$1" + i + "$3"));
                    }
                }
            }
            out.println();
        }
        f.close();
    }
}
