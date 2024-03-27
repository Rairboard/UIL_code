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

public class comic2 {
    public static void main(String[] args) throws Exception {
        new comic2().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("comic2").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        Map<Character,String> m = new HashMap<>();
		for(char c = 'A';c<='Z';c++){
			m.put(c,c-'A'+1 + "-");
		}
		while(f.hasNext()){
			String ln = f.nextLine();
			for (int i = 0; i < ln.length(); i++) {
				if (m.containsKey(ln.charAt(i))) {
					out.print(m.get(ln.charAt(i)));
				}
				else{
					out.print(ln.charAt(i));
				}
			}
			out.println();
		}
        f.close();
    }
}
