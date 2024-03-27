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

public class tanvi {
    public static void main(String[] args) throws Exception {
        new tanvi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("tanvi").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            List<Hour> al = new ArrayList<>();
            String[] ln = f.nextLine().split("]\\s+\\[");
            for (int i = 0; i < ln.length; i++) {
                al.add(new Hour(ln[i]));
            }
            List<Hour>[] dp = new ArrayList[n];
            Arrays.fill(dp,new ArrayList<>());
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if(al.get(i).s.compareTo(al.get(j).e)>0 && dp[j].size()+1 > dp[i].size()){
                        dp[i].add(al.get(j));
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                out.println(dp[i]);
            }
            out.println();
        }
        f.close();
    }
    class Hour{
        String s, e;
        public Hour(String st){
            String[] ln = st.split("\\s*,\\s+");
            s = ln[0].replaceAll("[\\[\\]]","");
            e = ln[1].replaceAll("[\\[\\]]","");
        }
        public String toString(){
            return "[" + s + ", " + e + "]";
        }
    }
}
