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

public class comic3 {
    public static void main(String[] args) throws Exception {
        new comic3().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("comic3").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
		Map<String,Character> m = new HashMap<>();
		for (int i = 1; i <= 26; i++) {
			m.put(i+"",(char)('A'+i-1));
		}
		while(f.hasNext()){
			String[] ln = f.nextLine().split("\\s+");
            for (int i = 0; i < ln.length; i++) {
                String[] w = ln[i].split("-");
                for (int j = 0; j < w.length; j++) {
                    if(m.containsKey(w[j])){
                        out.print(m.get(w[j]));
                    }
                    else{
                        out.print(w[j]);
                    }
                }
                if(i<ln.length-1){
                    out.print(" ");
                }
            }
            out.println();
        }
        f.close();
    }
}
