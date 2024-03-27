import java.util.*;
import java.io.*;

public class constanza {
    public static void main(String[] args) throws Exception {
        new constanza().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("constanza.dat"));
        //Scanner f = new Scanner(System.in);
        Map<String,String> m = new LinkedHashMap<>();
        m.put("red","");
        m.put("orange","");
        m.put("yellow","");
        m.put("green","");
        m.put("blue","");
        m.put("indigo","");
        m.put("violet","");
        while(f.hasNext()){
            String s =f.next();
            m.put(s,m.get(s)+"*");
        }
        for(String s : m.keySet()){
            System.out.printf("%-6s %s%n",s,m.get(s));
        }
        f.close();
    }
}
