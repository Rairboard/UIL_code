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

public class datacount {
    public static void main(String[] args) throws Exception {
        new datacount().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("datacount").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()) {
			String ln = f.nextLine();
			if(ln.replaceAll("[^a-zA-Z]","").matches("[A-Z]+")){
				out.println(new StringBuilder(ln).reverse());
			}
			else{
				out.println(ln.toUpperCase());
			}
        }
        f.close();
    }
}
