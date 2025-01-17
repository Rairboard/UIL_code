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

public class teams {
    public static void main(String[] args) throws Exception{
        new teams().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("teams").toLowerCase() + ".dat"));
		int times =f.nextInt();
		List<long[]> al= new ArrayList<>();
		long sum = 0;
		for (int asdf = 0; asdf < times; asdf++) {
			long A = f.nextLong(), R = f.nextLong();
			al.add(new long[]{A,R});
			sum+=R;
			if(asdf ==0){
				out.println(R);
			}
			else{
				Collections.sort(al, (a,b) -> Long.compare(a[0], b[0]));
				long YOUNG = 0;
				for (int i = 0; i < al.size() - al.size() / 2; i++) {
					YOUNG += al.get(i)[1];
				}
				long OLD = sum- YOUNG;
				out.println(Math.abs(OLD-YOUNG));
			}
		}
    }
}
