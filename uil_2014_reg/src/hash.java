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

public class hash {
    public static void main(String[] args) throws Exception {
        new hash().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hash").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int M = f.nextInt(), N = f.nextInt();
            boolean[] table = new boolean[M];
            f.nextLine();
            List<Integer> al = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String ln = f.nextLine();
                int h = hash(ln,M);
                al.add(h);
            }
            int notplace = recur(0, al, table, 0);
            out.println(notplace);
        }
        f.close();
    }
    public int recur(int i, List<Integer> al, boolean[] table, int notplace){
        if(i < al.size()){
            if(!table[al.get(i)]){
                table[al.get(i)] = true;
                return recur(i+1,al, table, notplace);
            }
            else{
                int left = ((al.get(i)-1)+table.length)%table.length;
                int right = (al.get(i) + 1) %table.length;

                if(table[left] && table[right]){
                    return recur(i+1, al, table, notplace+1);
                }
                else if(!table[left] && !table[right]){
                    table[left] = true;
                    int ans = recur(i+1, al, table,notplace);
                    table[left] = false;
                    table[right] = true;
                    ans = Math.min(ans, recur(i+1, al, table,notplace));
                    table[right] = false;
                    return ans;
                }
                else if(!table[left]){
                    table[left] = true;
                    int ans =  recur(i+1, al, table, notplace);
                    table[left] = false;
                    return ans;
                }
                else{
                    table[right] = true;
                    int ans = recur(i+1, al, table, notplace);
                    table[right] = false;
                    return ans;
                }
            }
        }
        return notplace;
    }
    public int hash(String ln, int M){
        int h = 0;
        for (int i = 0; i < ln.length(); i++) {
            h += (ln.charAt(i)-'a') * (int)Math.pow(2,i);
            h%=M;
        }
        return h%M;
    }
}
