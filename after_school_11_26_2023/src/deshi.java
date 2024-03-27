import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class deshi {
    public static void main(String[] args) throws Exception {
        new deshi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("deshi.dat"));
        // Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String s = f.nextLine();
            out.println(s.matches(".*[aeiou]{5}.*") || s.matches(".*[^aeiou]{8}.*")?"NOT ACCEPTABLE " + s :"ACCEPTABLE " + s);
        }
    }
}
