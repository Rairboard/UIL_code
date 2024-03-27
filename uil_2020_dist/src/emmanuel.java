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

public class emmanuel {
    public static void main(String[] args) throws Exception {
        new emmanuel().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("emmanuel").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int[] ar = Arrays.stream(f.nextLine().replaceAll("[\\{\\}]","").split(",")).mapToInt(Integer::parseInt).toArray();
			Map<Integer,Integer> m = new HashMap<>(), tm = new TreeMap<>(Collections.reverseOrder());
			for (int i = 0; i < ar.length; i++) {
				m.putIfAbsent(ar[i],0);
				m.put(ar[i],m.get(ar[i])+1);
			}
			for(Integer i : m.keySet()){
				tm.put(m.get(i),i);
			}
			int N = new ArrayList<>(tm.values()).get(0);
			int time = new ArrayList<>(tm.keySet()).get(0);
			out.println(N + " appeared " + time  + " time(s)");
        }
        f.close();
    }
}
