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

public class snapshot {
    public static void main(String[] args) throws Exception {
        new snapshot().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("snapshot.dat"));
        //Scanner f = new Scanner(System.in);
		Map<Double,Integer> m = new TreeMap<>(Collections.reverseOrder());
		int enroll = 0, tardy = 0;
        for(int asdf = 1; asdf<=6;asdf++){
			int e = f.nextInt(), a = f.nextInt(), t = f.nextInt();
			enroll+=e;
			tardy += t;
			m.put((double)(e-a)/e,asdf);
        }
		List<Integer> classes = new ArrayList<>(m.values());
		out.println(enroll+"\n"+tardy);
		out.println(classes.get(0));
		classes.forEach( element -> out.print(element + " "));
        f.close();
    }
}
