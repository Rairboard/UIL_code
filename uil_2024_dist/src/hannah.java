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

public class hannah {
    public static void main(String[] args) throws Exception {
        new hannah().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hannah").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			Map<String,Map<String,Long>> score = new TreeMap<>();
			Map<String,String> div = new HashMap<>();
			int n = f.nextInt();
			f.nextLine();
			for (int i = 0; i < n; i++) {
				String[] ln = f.nextLine().trim().split("\\s+");
//				out.println(Arrays.toString(ln));
				long sum = 0;
				for (int j = 2; j < ln.length; j++) {
					sum+=Long.parseLong(ln[j]);
				}
				String team = ln[0], division = ln[1];
				score.putIfAbsent(division, new HashMap<>());
				score.get(division).put(team,sum);
				div.put(team,division);
			}
			for (int i = 0; i < n; i++) {
				String[] ln = f.nextLine().trim().split("\\s+");
				String team = ln[0];
				long newScore = score.get(div.get(team)).get(team);
				for (int j = 1; j < ln.length; j++) {
					newScore+=Long.parseLong(ln[j]);
				}
				score.get(div.get(team)).put(team,newScore);
			}
			for(String division : score.keySet()) {
				Map<Long, String> tm = new TreeMap<>(Collections.reverseOrder());
				for (String team : score.get(division).keySet()) {
					tm.put(score.get(division).get(team), team);
				}
				out.println("Classification " + division + " Results");
				for(Long sc : tm.keySet()){
					out.println(tm.get(sc) + " " + sc);
				}
			}
			out.println("=".repeat(25));
        }
        f.close();
    }
}
