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

public class histonum {
    public static void main(String[] args) throws Exception {
        new histonum().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("histonum").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int[] cnt = new int[10];
		while(f.hasNext()){
			String ln = f.nextLine();
			for (int i = 0; i < ln.length(); i++) {
				int n = Integer.parseInt(ln.substring(i,i+1));
				cnt[n]++;
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i]>0)out.println(i+"|" + "*".repeat(cnt[i]));
		}
        f.close();
    }
}
