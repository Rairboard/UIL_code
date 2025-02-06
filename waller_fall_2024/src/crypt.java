import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class crypt {
    public static void main(String[] args) throws Exception {
        new crypt().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("crypt").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String s = f.next();
            String ln = f.nextLine().trim();
            char[] copy = ln.toCharArray();
            Arrays.sort(copy);
            String sorted = new String(copy);
            char[][] m = new char[ln.length()/s.length()][s.length()];
            int ind = 0;
            List<E> al = new ArrayList<>();
            for (int i = 0; i < m.length   ; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = ln.charAt(ind);
                    ind++;
                }
            }
            for(int c = 0;c<s.length();c++){
                String col = "";
                for (int r = 0; r < m.length; r++) {
                    col+=m[r][c];
                }
                al.add(new E(col, s.charAt(c)));
            }
            Collections.sort(al, (a,b) ->sorted.indexOf(a.c) - sorted.indexOf(b.c));
            m = new char[ln.length()/s.length()][s.length()];
            for (int i = 0; i < m[0].length; i++) {
                for (int j = 0; j < m.length; j++) {
                    m[j][i] = al.get(i).s.charAt(j);
                }
            }
            for(char[] line : m){
                out.print(line);
            }
            out.println();
        }
        f.close();
    }
    class E{
        String s ;
        char c;
        public E(String s, char ch){
            this.s = s;
            this.c = ch;
        }
    }
}
