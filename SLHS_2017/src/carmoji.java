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

public class carmoji {
    public static void main(String[] args) throws Exception {
        new carmoji().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("carmoji").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
		String[] word = "laugh smile disguise awkward shock".split(" ");
		String[] emo = ":D :) :{) :] O.o".split(" ");
		String[] reg = ":D :\\) :\\{\\) :\\] O.o".split(" ");

        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String[] ln = f.nextLine().trim().split("\\s+");
			boolean[] replace = new boolean[ln.length];
			for (int i = 0; i < ln.length; i++) {
				for (int j = 0; j < word.length; j++) {
					if ( ln[i].contains(word[j])) {
						ln[i] = ln[i].replaceAll(word[j],emo[j]);
						replace[i] = true;
					}
					if (!replace[i] && ln[i].contains(emo[j])) {
						ln[i] = ln[i].replaceAll(reg[j],word[j]);
						replace[i] = true;
					}
				}
			}
			for(String s : ln){
				out.print(s+" ");
			}
			out.println();
		}
        f.close();
    }
}
