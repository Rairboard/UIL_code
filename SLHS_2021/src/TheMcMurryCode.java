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

public class TheMcMurryCode {
    public static void main(String[] args) throws Exception {
        new TheMcMurryCode().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("TheMcMurryCode")));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			boolean solved = true;
			int n = f.nextInt();
			f.nextLine();
			List<String> al = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				al.add(f.nextLine());
			}
			n = f.nextInt();
			f.nextLine();
			String full = "";
			for (int i = 0; i < n; i++) {
				String ln = f.nextLine().replaceAll("\\s+","");
				if((i+1)%2==1){
					for (int j = 0; j < ln.length(); j++) {
						full+=ln.charAt(j);
					}
				}
				else{
					for (int j = ln.length()-1; j > -1; j--) {
						full+=ln.charAt(j);
					}
				}
			}
			for (int i = 0; i < al.size(); i++) {
				if (!full.contains(al.get(i))) {
					solved = false;
					break;
				}
			}
			if(solved){
				out.println("All words found!");
			}else{
				out.println("Unsolvable. Not fair!");
			}
        }
        f.close();
    }
}
