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

public class chess {
    public static void main(String[] args) throws Exception {
        new chess().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("chess").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			long fr = 0, wario = 0;
			for (int i = 0; i < 8; i++) {
				String ln = f.nextLine();
				for (int j = 0; j < ln.length(); j++) {
					if (ln.substring(j,j+1).matches("[a-z]")) {
						switch (ln.charAt(j)){
							case 'p': wario--;break;
							case 'h','b':wario-=3;break;
							case 'r':wario-=5;break;
							case 'q': wario-=9;break;
						}
					}
					if(ln.substring(j,j+1).matches("[A-Z]")){
						switch (ln.charAt(j)){
							case 'P': fr++;break;
							case 'H','B':fr+=3;break;
							case 'R':fr+=5;break;
							case 'Q': fr+=9;break;
						}
					}
				}
			}
			out.println(wario + fr);
		}
        f.close();
    }
}
