import javax.lang.model.util.ElementScanner6;
import java.util.*;
import java.io.*;

public class johnny {
    public static void main(String[] args) throws Exception {
        new johnny().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("johnny.dat"));
        //Scanner f = new Scanner(System.in);
        Map<String,String> m =new HashMap<>();
        while(f.hasNext()){
           String[] s =f.nextLine().split("\\s+");
           if(!s[0].matches("[^A-Z]+")){
               for (int i = 0; i < s.length; i++) {
                   System.out.print(m.get(s[i]));
               }
               System.out.println();
           }else{
               String key = s[0];
               String[] l = s[1].split("/");
               for (int i = 0; i < l.length; i++) {
                   m.put(l[i],key);
               }
           }
        }
        f.close();
    }
}
