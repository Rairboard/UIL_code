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

public class isabella {
    public static void main(String[] args) throws Exception {
        new isabella().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("isabella.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
		Map<String,Map<String,Double>> m = new HashMap<>();
        while (times-- > 0) {
			String s = f.next();
			m.putIfAbsent(s,new HashMap<>());
			m.get(s).put(f.next(),f.nextDouble());
        }
		times =f.nextInt();
		while(times-->0){
			double sum = 0;
			int ledger = f.nextInt();
			f.nextLine();
			List<String[]> al = new ArrayList<>();
			while(ledger-->0){
				al.add(f.nextLine().split("\\s+"));
			}
			double ledgerValue = f.nextDouble();
			String checkLedger = f.next();
			for (int i = 0; i < al.size(); i++) {
				double money = Double.parseDouble(al.get(i)[0]);
				String s = al.get(i)[1];
				if (s.equals(checkLedger)) {
					sum+=money;
				}
				else{
					sum+= money * m.get(s).get(checkLedger);
				}
			}
			out.println(sum == ledgerValue ? "GOOD LEDGER":"BAD LEDGER");
		}
        f.close();
    }
}
