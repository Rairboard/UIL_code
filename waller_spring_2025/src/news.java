import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class news {
    public static void main(String[] args) throws Exception {
        new news().run();
    }

    public void run() throws Exception {
        List<String> V = new ArrayList<>(Arrays.asList("Magneto,Juggernaut,Apocalypse,Mystique,Sentinels".split(",")));
        List<String> W = new ArrayList<>(Arrays.asList("Thanos,Galactus,Kang,Ultron,Graviton".split(",")));
        Scanner f = new Scanner(new File(("news").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);

        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            boolean world = false, villain = false;
            String[] ln = f.nextLine().trim().split("\\s+");
//            out.println(Arrays.toString(ln));
            for (int i = 0; i < ln.length; i++) {
                if (V.contains(ln[i])) {
                    villain = true;
                }
                if (W.contains(ln[i])) {
                    world = true;
                }
            }
            if(world) out.println("Calling All Heroes.");
            else if(villain) out.println("Sharpen Your Claws Wolverine.");
            else out.println("Business as Usual.");
        }
        f.close();
    }
}
