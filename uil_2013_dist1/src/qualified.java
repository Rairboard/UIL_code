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

public class qualified {
    public static void main(String[] args) throws Exception {
        new qualified().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("qualified").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String s = f.next();
			int score = f.nextInt();
			String conf = f.next();
			if (conf.equals("STC") && score >= 560) {
				out.println(s);
			}
            else if(conf.equals("WTC") && score>=340){
                out.println(s);
            }
            else if(conf.equals("NTC")&&score>=420){
                out.println(s);
            }
            else if(conf.equals("CTC")&&score>=370){
                out.println(s);
            }
            else if(conf.equals("LVC")&&score>=470){
                out.println(s);
            }
        }
        f.close();
    }
}
