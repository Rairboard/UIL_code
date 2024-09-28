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

public class christie {
    public static void main(String[] args) throws Exception {
        new christie().run();

    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("christie").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int a = f.nextInt(), b = f.nextInt();
			String ln = "";
			f.nextLine();
			for (int i = a; i <=b ; i++) {
				long s = 0, tmp = i;
				while(tmp>0){
					s += (tmp%10) * (tmp%10);
					tmp/=10;
				}
				if(Math.sqrt(s) == (int)Math.sqrt(s)){
					ln+=i + " ";
				}
			}
			if(ln.isEmpty()){
				out.println("NONE");
			}
			else{
				out.println(ln.trim());
			}
        }
        f.close();
    }
}
