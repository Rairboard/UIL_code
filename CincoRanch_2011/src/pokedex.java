import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class pokedex {
    public static void main(String[] args) throws Exception {
        new pokedex().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("pokedex").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        Map<String,String> correct = new HashMap<>();
        Map<String,String> flip = new HashMap<>();
        int n = f.nextInt();
        for (int i = 0; i < n; i++) {
            correct.put(f.next(),f.next());
        }
        n = f.nextInt();
        for (int i = 0; i < n; i++) {
            String a = f.next();
            flip.put(f.next(),a);
        }
        n = f.nextInt();
        for (int i = 0; i < n; i++) {
            String s = f.next();
            out.println(correct.get(flip.get(s)));
        }
        f.close();
    }
}
