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

public class score {
    public static void main(String[] args) throws Exception {
        new score().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("score").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
		List<Integer> al = new ArrayList<>();
        for (int asdf = 1; asdf <= times; asdf++) {
			al.add(f.nextInt());
        }
		Collections.sort(al);
		out.println("FIRST PLACE: " + al.get(al.size()-1) + "\nSECOND PLACE: " + al.get(al.size()-2) + "\nTHIRD PLACE: " + al.get(al.size()-3) + "\nLAST PLACE: " + al.get(0));
        f.close();
    }
}
