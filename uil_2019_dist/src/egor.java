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

public class egor {
    public static void main(String[] args) throws Exception {
        new egor().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("egor").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        Set<String> s = new TreeSet<>();
        while (times-- > 0) {
            String name = f.nextLine();
            if(name.length()<=8 && !name.equalsIgnoreCase("Egor") && !name.matches(".*ph.*")){
                if(name.length()>=5 && !name.toLowerCase().matches(".*[comy]+.*") && name.substring(0,1).matches("[A-N]")){
                    s.add(name);
                }
            }
        }
        for(String ss : s){
            out.println(ss);
        }
        f.close();
    }
}
