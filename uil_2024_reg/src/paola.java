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

public class paola {
    public static void main(String[] args) throws Exception {
        new paola().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("paola").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int r = f.nextInt(), c = f.nextInt(), cm = f.nextInt();
			List<List<Long>> al = new ArrayList<>();
			for (int i = 0; i < r; i++) {
				al.add(new ArrayList<>());
				for (int j = 0; j < c; j++) {
					al.get(i).add(f.nextLong());
				}
			}
			if(f.hasNext()){
				f.nextLine();
			}
			for (int i = 0; i < cm; i++) {
				String[] ln = f.nextLine().trim().split("\\s+");
				if (ln[0].equals("ROTROW")) {
					int pos = Integer.parseInt(ln[1]);
					int N = Integer.parseInt(ln[2]);
					Collections.rotate(al.get(pos),N);
				} else if (ln[0].equals("ROTCOL")) {
					List<Long> tmp = new ArrayList<>();
					int col = Integer.parseInt(ln[1]);
					int N = Integer.parseInt(ln[2]);
					for (int j = 0; j < al.size(); j++) {
						tmp.add(al.get(j).get(col));
					}
					Collections.rotate(tmp,N);
					for(int j = 0;j < al.size();j++){
						al.get(j).set(col,tmp.get(j));
					}
				}
				else if(ln[0].equals("ADDROW")){
					int pos = Integer.parseInt(ln[1]);
					String[] val = ln[2].replaceAll("[\\[\\],]","").split("\\s+");
				}
			}
        }
        f.close();
    }
}
