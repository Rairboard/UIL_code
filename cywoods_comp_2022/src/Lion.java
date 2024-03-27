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

public class Lion {
    public static void main(String[] args) throws Exception {
        new Lion().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Lion").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			Calendar s = new GregorianCalendar(f.nextInt(), f.nextInt()-1,f.nextInt());
			Calendar e = new GregorianCalendar(f.nextInt(), f.nextInt()-1,f.nextInt());
			int days = 0;
			while(s.compareTo(e)<0){
				days++;
				s.add(Calendar.DATE,1);
			}
			out.printf("%,d\n",days);
        }
        f.close();
    }
}
