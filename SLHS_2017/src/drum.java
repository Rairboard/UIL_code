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

public class drum {

    Map<String,List<String>>m;
    public static void main(String[] args) throws Exception {
        new drum().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("drum").toLowerCase() + ".in"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n =f.nextInt();
            f.nextLine();
            m = new HashMap<>();
            m.put("guitar", new ArrayList<>());
            m.put("bass", new ArrayList<>());
            m.put("singer" , new ArrayList<>());
            m.put("triangle", new ArrayList<>());
            for (int i = 0; i < n; i++) {
                String[] ln = f.nextLine().trim().split("\\s+");
                for (int j = 1; j < ln.length; j++) {
                    m.get(ln[j]).add(ln[0]);
                }
            }
            int cnt = 0;
            for (int i = 0; i < m.get("guitar").size(); i++) {
                String a = m.get("guitar").get(i);
                for (int j = 0; j < m.get("bass").size(); j++) {
                    String b = m.get("bass").get(j);
                    if(b.equals(a)) continue;
                    for (int k = 0; k < m.get("singer").size(); k++) {
                        String c  =m.get("singer").get(k);
                        if(c.equals(b) || c.equals(a)) continue;
                        for (int l = 0; l < m.get("triangle").size(); l++) {
                            String d = m.get("triangle").get(l);
                            if (d.equals(c) || d.equals(b) || d.equals(a)) continue;
                            cnt++;
                        }
                    }
                }
            }
            out.println(cnt);
        }
        f.close();
    }
}
