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

public class wojtek {
    public static void main(String[] args) throws Exception {
        new wojtek().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("wojtek").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			long[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
			int cnt = 0;
			while(!empty(ar)){
				cnt++;
				long[] c = {ar[0],ar[1],ar[2],ar[3]};
				ar[0] = Math.max(c[0],c[1]) - Math.min(c[0],c[1]);
				ar[1] = Math.max(c[2],c[1]) - Math.min(c[2],c[1]);
				ar[2] = Math.max(c[2],c[3]) - Math.min(c[2],c[3]);
				ar[3] = Math.max(c[0],c[3]) - Math.min(c[0],c[3]);
			}
			out.println("Case #" + asdf + ": " + cnt);
        }
        f.close();
    }
	public boolean empty(long[] ar){
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]!=0){
				return false;
			}
		}
		return true;
	}
}
