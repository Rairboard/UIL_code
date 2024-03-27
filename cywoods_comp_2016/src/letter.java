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

public class letter {
    public static void main(String[] args) throws Exception {
        new letter().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("letter").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String s = "";
		while(f.hasNext()){
			String ln  =f.nextLine();
			if(ln.isEmpty()){
				s+=" ";
			}else{
				s+=ln.charAt(2);
			}
		}
		out.println(s);
        f.close();
    }
}
