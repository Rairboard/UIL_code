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

public class students {
    public static void main(String[] args) throws Exception {
        new students().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("students").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int t = 0;t<times;t++){
            Map<Long,String> m =new TreeMap<>(Collections.reverseOrder());
            int n = f.nextInt();
            f.nextLine();
            for (int i = 0; i < n; i++) {
                String name = f.next();
                long score = f.nextLong();
                m.put(score,name);
            }
            if(f.hasNext()){
                f.nextLine();
            }
            for(Long score : m.keySet()){
                out.println(m.get(score) + " " + score);
            }
            if(t<times-1){
                out.println();
            }
        }
        f.close();
    }
}
