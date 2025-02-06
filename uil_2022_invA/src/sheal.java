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

public class sheal {
	HashSet<String> hs;
    public static void main(String[] args) throws Exception {
        new sheal().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sheal").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			hs = new HashSet<>();
			String ln = f.next();
			int i = f.nextInt()-1;
			permu(ln, "");
			List<String> al = new ArrayList<>(hs);
			Collections.sort(al);
			out.println(al.get(i));
        }
        f.close();
    }
	public void permu(String orig, String cur){
		if(!cur.isEmpty()) hs.add(cur);
		for(int i = 0;i < orig.length();i++){
			permu(orig.substring(0,i) + orig.substring(i+1), cur + orig.charAt(i));
		}
	}
}
