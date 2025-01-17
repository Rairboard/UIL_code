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

public class ben {
    public static void main(String[] args) throws Exception {
        new ben().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("ben").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine().trim();
            Set<String> hs = new HashSet<>();
            int ans=0;
            for (int i = 0; i < ln.length()-1; i++) {
                int last = i;
                for(int j = i+1;j<=ln.length();j++){
                    if (ln.substring(i, j).matches(".*p.*i.*d.*g.*e.*o.*n.*")) {
                        hs.add(ln.substring(i,j));
                        last = j;
                    }
                }
                if(last!=i){
                    i = last;
                }
                ans = hs.size() % (int)(1e9+7);
            }
            out.println(ans);
        }
        f.close();
    }
}
