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

public class EscapeNuttIsland {
    public static void main(String[] args) throws Exception {
        new EscapeNuttIsland().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("EscapeNuttIsland").toLowerCase()));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n = f.nextInt();
			long fee = f.nextInt(), total = 0;
			Map<String,Long> m = new HashMap<>();
			for (int i = 0; i < n; i++) {
				m.put(f.next(),f.nextLong());
			}
			if(f.hasNext()){
				f.nextLine();
			}
			String ln = f.nextLine();
			for (int i = 0; i < ln.length(); i++) {
				if(m.containsKey(ln.substring(i,i+1))){
					total+=m.get(ln.substring(i,i+1));
				}
			}
			out.print(total+fee+" ");
        }
        f.close();
    }
}
