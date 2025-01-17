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

public class json {
    public static void main(String[] args) throws Exception {
        new json().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("json").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        Map<String,Map<String,String>> m = new HashMap<>();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine();
            if (ln.matches("print.*")) {
                String item = ln.substring(ln.indexOf("(")+1,ln.indexOf(")"));
                String print = "{";
                for(String key: m.get(item).keySet()){
                    print+=key + " : " + m.get(item).get(key) + ", ";
                }
                print = print.substring(0,print.length()-2) + "}";
                out.println(print);
            }
            else{
                String[] line = ln.split("\\.")[1].split("\\s+=\\s+");
                String item = ln.split("\\.")[0];
                String key = line[0];
                String value = line[1];
                m.putIfAbsent(item, new LinkedHashMap<>());
                m.get(item).put(key,value);
            }
        }
        f.close();
    }
}
