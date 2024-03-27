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

public class decrypt {
    public static void main(String[] args) throws Exception {
        new decrypt().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("decrypt").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			List<String> al = new ArrayList<>(Arrays.asList(f.nextLine().split("")));
			for (int i = 0; i < al.size(); i++) {
				al.set(i,(char)(al.get(i).charAt(0) - 2) + "");
			}
			int ins = f.nextInt();
			for (int i = 0; i < ins; i++) {
				char dir = f.next().charAt(0);
				int N = f.nextInt();
				if(dir=='L'){
					N = -N;
				}
				Collections.rotate(al,N);
			}
			if(f.hasNext()){
				f.nextLine();
			}
			for (String s : al) {
				out.print(s);
			}
			out.println();
        }
        f.close();
    }
}
