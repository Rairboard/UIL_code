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

public class joyce {
    public static void main(String[] args) throws Exception {
        new joyce().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("joyce").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            Map<Character,Integer> m = new HashMap<>();
            String ln = f.nextLine().toLowerCase().replaceAll("[^a-z]","");
            for (int i = 0; i < ln.length(); i++) {
                m.put(ln.charAt(i),m.getOrDefault(ln.charAt(i),0)+1);
            }
            if(m.size()==26){
                boolean perfect = true;
                for(Character c : m.keySet()){
                    if(m.get(c)!=1){
                        perfect = false;
                        break;
                    }
                }
                out.println(perfect?"perfect pangram":"pangram");
            }
            else{
                out.print("missing ");
                for(char c = 'a';c<='z';c++){
                    if(!m.containsKey(c)){
                        out.print(c);
                    }
                }
                out.println();
            }
        }
        f.close();
    }
}
