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

public class adv103 {
    public static void main(String[] args) throws Exception {
        new adv103().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("adv103").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		String ln = "";
		Map<String,String> tm = new TreeMap<>();
		while (f.hasNext()) {
			ln+=f.nextLine();
		}
		for (int i = 0; i < ln.length()-1; i++) {
			for (int j = i+1; j <= ln.length(); j++) {
				String part = ln.substring(i,j).toLowerCase().replaceAll("[^a-z]","");
				if(part.length()>=5 && part.equals(new StringBuilder(part).reverse().toString())){
					tm.put(part,ln.substring(i,j));
					i = j-1;
					break;
				}
			}
		}
		for(String s : tm.keySet()){
			out.println(tm.get(s));
		}
        f.close();
    }
}
