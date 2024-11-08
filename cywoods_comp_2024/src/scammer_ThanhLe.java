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

public class scammer_ThanhLe {
    public static void main(String[] args) throws Exception {
        new scammer_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("scammers").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine();
			String name = ln.substring(0,ln.indexOf(":"));
			while(f.hasNext()){
				String tmp = f.nextLine();
				if(tmp.trim().isEmpty()){
					break;
				}
				ln+=tmp.trim();
			}
			ln = ln.trim();
			if (ln.toLowerCase().matches(".*s.*c.*a.*m.*")) {
				out.println(name + " is a scammer!");
			}
			else{
				out.println(name + " is safe to text.");
			}
        }
        f.close();
    }
}
