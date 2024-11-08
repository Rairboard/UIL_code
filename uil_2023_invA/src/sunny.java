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

public class sunny {
    public static void main(String[] args) throws Exception {
        new sunny().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sunny").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        List<String> al = new ArrayList<>();
		while(f.hasNext()){
			String code = f.next();
			String name = f.nextLine().trim();
			al.add(name + " (" + code + ")");
		}
		Collections.sort(al);
		al.forEach(e -> out.println(e));
        f.close();
    }
}
