import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class bangers_ThanhLe {
    public static void main(String[] args) throws Exception {
        new bangers_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bangers").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String[] ln = f.nextLine().trim().split("\\s+");
			out.println(ln[1] + " "+(ln[0].toLowerCase().equals("jared")?"IS A BANGER": "IS NOT A BANGER"));
        }
        f.close();
    }
}
