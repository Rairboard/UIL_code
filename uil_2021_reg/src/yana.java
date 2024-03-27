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

public class yana {
    public static void main(String[] args) throws Exception {
        new yana().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("yana").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        char[][] m = new char[8][8];
        String alp = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz.";
        int in = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                m[j][i] = alp.charAt(in++);
            }
        }
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int[] rr = Arrays.stream(f.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int nm = rr[rr.length-1];
            String copy = "";
            for (int i = 0; i < m[0].length; i++) {
                List<Character> al = new ArrayList<>();
                for (int j = 0; j < m.length; j++) {
                    al.add(m[j][i]);
                }
                Collections.rotate(al,rr[i]%8);
                for (int j = 0; j < al.size(); j++) {
                    copy+=al.get(j);
                }
            }
            for (int i = 1; i <= nm; i++) {
                String ln = f.nextLine().replaceAll("-"," ");
                String result = "";
                for (int j = 0; j < ln.length(); j++) {
                    result+=copy.charAt(alp.indexOf(ln.charAt(j)));
                }
                out.printf("[%d:%d]--\"%s\"\n",asdf,i,result);
            }
            out.println("=".repeat(10));
        }
        f.close();
    }
}
