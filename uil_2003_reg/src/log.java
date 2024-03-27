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

public class log {
    public static void main(String[] args) throws Exception {
        new log().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("log").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		int cur = 1;
		Map<Integer,Map<String,Integer>> m = new TreeMap<>();
		while (f.hasNext()) {
			String[] ln = f.nextLine().split("\\s+");
			if (ln[0].equals("DATABASE")) {
				m.put(Integer.parseInt(ln[1]),new TreeMap<>());
				cur = Integer.parseInt(ln[1]);
			} else if (ln[0].equals("Insert")) {
				m.get(cur).put(ln[1],Integer.parseInt(ln[2]));
			} else if (ln[0].equals("Delete")) {
				m.get(cur).remove(ln[1]);
			} else if(ln[0].equals("Update")) {
				m.get(cur).put(ln[1],Integer.parseInt(ln[2]));
			} else if(!ln[0].equals("LOG")){
				m.get(cur).put(ln[0], Integer.parseInt(ln[1]));
			}
		}
		for(Integer db : m.keySet()){
			out.println("DATABASE " + db);
			for(String s : m.get(db).keySet()){
				out.println(s +" " + m.get(db).get(s));
			}
		}
        f.close();
    }
}
