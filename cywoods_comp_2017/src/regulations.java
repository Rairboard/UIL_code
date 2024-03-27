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

public class regulations {
	List<String> color = new ArrayList<>(Arrays.asList("Space_Grey,Imperial_Black,Royal_Guard_Red".split(",")));
	List<String> smell = new ArrayList<>(Arrays.asList("Clean,Fruity,Perfumed".split(",")));
    public static void main(String[] args) throws Exception {
        new regulations().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("regulations").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n = f.nextInt();
			boolean b = true;
			for (int i = 0; i < n; i++) {
				String c = f.next();
				long l = f.nextLong(), w = f.nextLong(), h = f.nextLong(), weight = f.nextLong();
				String s = f.next();
				if(!color.contains(c) || !smell.contains(s) || l!=w || l!= h || w!=h||weight>=20){
					b = false;
				}
			}
			out.println(b?"Never tell me the odds!":"It's a trap!");
        }
        f.close();
    }
}
