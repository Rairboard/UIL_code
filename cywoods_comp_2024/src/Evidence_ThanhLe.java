import java.util.*;
import java.io.File;
import java.util.Arrays;

import static java.lang.System.*;

public class Evidence_ThanhLe {
    public static void main(String[] args) throws Exception {
        new Evidence_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Evidence").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            List<String> al = new ArrayList<>(Arrays.asList(f.nextLine().trim().split("\\s+")));
            String[] ln = f.nextLine().trim().split("\\s+");
            for (int i = 0; i < ln.length; i++) {
                if(al.contains(ln[i])){
                    al.remove(al.indexOf(ln[i]));
                }
            }
            out.print("Missing evidence: ");
            al.forEach(e -> out.print(e+" "));
            out.println();
        }
        f.close();
    }
}
