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

public class missingcrewmates {
    public static void main(String[] args) throws Exception {
        new missingcrewmates().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("missingcrewmates").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
		List<String> al = new ArrayList<>();

        for (int asdf = 1; asdf <= times; asdf++) {
			al.add(f.nextLine().trim());
        }
		times = f.nextInt();
		f.nextLine();
		for (int i = 0; i < times; i++) {
			al.remove(f.nextLine().trim());
		}
		for(String s : al){
			out.println(s);
		}
        f.close();
    }
}
