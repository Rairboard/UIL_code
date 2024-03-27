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

public class adv57 {
    public static void main(String[] args) throws Exception {
        new adv57().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("adv57").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			List<String> al = new ArrayList<>();
			boolean q = true;
			for(char c = 'A';c<='F';c++){
				al.add(c+"");
			}
			String[] ln = f.nextLine().split("\\s+");
			for (int i = 0; i < ln.length; i++) {
				if (ln[i].equals("END")) {
					break;
				}
				else if (ln[i].equals("SWITCH")) {
					q = !q;
				} else if (ln[i].equals("POP")) {
					if (q) {
						out.print(al.removeFirst());
					} else {
						out.print(al.removeLast());
					}
				} else if (ln[i].equals("PUSH")) {
					al.add(ln[i+1]);
					i++;
				}
			}
			if(!al.isEmpty()){
				out.print(" ");
				for (int i = 0; i < al.size(); i++) {
					out.print(al.get(i));
				}
			}
			out.println();
        }
        f.close();
    }
}
