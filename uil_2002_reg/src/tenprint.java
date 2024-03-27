import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.util.regex.Pattern;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class tenprint {
    public static void main(String[] args) throws Exception {
        new tenprint().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("tenprint").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
		Map<String,String> m = new LinkedHashMap<>();
        while (times-- > 0) {
			String[] ln = f.nextLine().split("\\s+");
			m.put(ln[0],ln[1]);
        }
		while(f.hasNext()){
			String ln = f.nextLine().replaceAll("\\?",".");
			List<String> al = new ArrayList<>();
			for(String s : m.keySet()){
				if(Pattern.matches(ln,s)){
					al.add(m.get(s));
				}
			}
			if(al.size()==0){
				out.println("No Suspects");
			}
			else{
				for (int i = 0; i < al.size(); i++) {
					out.println(al.get(i));
				}
			}
			out.println();
		}
        f.close();
    }
}
