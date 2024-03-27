import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class router {
    public static void main(String[] args) throws Exception {
        new router().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("router").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
		List<String> al = new ArrayList<>();
        while (times-- > 0) {
			al.add(f.nextLine());
        }
		while(f.hasNext()){
			String ln = f.nextLine();
			List<String> asdf = new ArrayList<>();
			for (int i = 0; i < al.size(); i++) {

			}
		}
        f.close();
    }
}
