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

public class confcostumes {
    public static void main(String[] args) throws Exception {
        new confcostumes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("confcostumes").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            Map<String,Integer> cnt = new HashMap<>();
            int n = f.nextInt();
            String[][] m = new String[n][];
            f.nextLine();
            for (int i = 0; i < n; i++) {
                int c = f.nextInt();
                f.nextLine();
                m[i] = f.nextLine().trim().split("\\s+");
            }
            boolean good = recur(m, 0,new HashSet<>());
            if(good) out.println("Everyone's happy!");
            else out.println("Someone's out of luck!");
        }
        f.close();
    }
    public boolean recur(String[][] m, int ind, HashSet<String> visited){
        if(ind==m.length){
            return visited.size()==m.length;
        }
        else{
            for (int i = 0; i < m[ind].length; i++) {
                if (!visited.contains(m[ind][i])) {
                    visited.add(m[ind][i]);
                    if(recur(m, ind+1,visited)) return true;
                    visited.remove(m[ind][i]);
                }
            }
        }
        return false;
    }
}
