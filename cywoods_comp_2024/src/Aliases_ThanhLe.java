import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class Aliases_ThanhLe {
    public static void main(String[] args) throws Exception {
        new Aliases_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Aliases").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String[] ln = f.nextLine().split("\\s+");
			for (int i = 0; i < ln.length; i++) {
				String s = ln[i];
				String ss = "";
				for (int j = 0; j < s.length(); j++) {
					if((s.charAt(j)>='a'&&s.charAt(j)<='z') || (s.charAt(j)>='A'&&s.charAt(j)<='Z')){
						ss+=s.charAt(j);
					}
				}
				out.print(ss+ " ");
			}
			out.println();
        }
        f.close();
    }
}
