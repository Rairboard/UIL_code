import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class michal {
    public static void main(String[] args) throws Exception {
        new michal().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("michal").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		String[] num = new String[10];
		num[0] = "***" +
				" _ " +
				"| |" +
				"|_|" +
				"   " +
				"***";
		num[1] = "***" +
				"   " +
				"  |" +
				"  |" +
				"   " +
				"***";
		num[2] = "***" +
				" _ " +
				" _|" +
				"|_ " +
				"   " +
				"***";
		num[3] = "***" +
				" _ " +
				" _|" +
				" _|" +
				"   " +
				"***";
		num[4] = "***" +
				"   " +
				"|_|" +
				"  |" +
				"   " +
				"***";
		num[5]  ="***" +
				" _ " +
				"|_ " +
				" _|" +
				"   " +
				"***";
		num[6] = "***" +
				" _ " +
				"|_ " +
				"|_|" +
				"   " +
				"***";
		num[7] = "***" +
				" _ " +
				"  |" +
				"  |" +
				"   " +
				"***";
		num[8] = "***" +
				" _ " +
				"|_|" +
				"|_|" +
				"   " +
				"***";
		num[9] = "***" +
				" _ " +
				"|_|" +
				"  |" +
				"   " +
				"***";
//		out.println(Arrays.toString(num));
		int times = f.nextInt();
		f.nextLine();
		for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine();
			String[] ans= new String[6];
			Arrays.fill(ans, "");
			for (int i = 0; i < ans.length; i++) {
				ans[i]+="*";
			}
			for (int i = 0; i < ln.length(); i++) {
				int index = Integer.parseInt(ln.substring(i,i+1));
				for (int j = 0; j < 6; j++) {
					ans[j]+=num[index].substring(j *3, j * 3 + 3);
				}
			}
			for (int i = 0; i < 6; i++) {
				ans[i]+="*";
			}
			for (int i = 0; i < 6; i++) {
				out.println(ans[i]);
			}
		}
        f.close();
    }
}
