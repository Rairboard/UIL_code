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

public class wordfinder {
    public static void main(String[] args) throws Exception {
        new wordfinder().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("wordfinder").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
		Map<String,int[]> m = new HashMap<>();
        int times = f.nextInt(), p = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine();
			m.put(ln, new int[26]);
			for (int i = 0; i < ln.length(); i++) {
				m.get(ln)[ln.charAt(i)-'a']++;
			}
        }
		while(p-->0){
			String ln = f.nextLine();
			int cnt = 0;
			int[] count =new int[26];
			for (int i = 0; i < ln.length(); i++) {
				count[ln.charAt(i)-'a']++;
			}
			for(String s : m.keySet()){
				boolean canMake = true;
				for (int i = 0; i < count.length; i++) {
					if(count[i] < m.get(s)[i]){
						canMake = false;
						break;
					}
				}
				if(canMake){
					cnt++;
				}
			}
			out.println(cnt);
		}
        f.close();
    }
}
