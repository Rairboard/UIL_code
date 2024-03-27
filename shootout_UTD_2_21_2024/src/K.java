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

public class K {
    public static void main(String[] args) throws Exception {
        new K().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("K").toLowerCase() + ".txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			double fr = f.nextDouble();
			double j = fr;
			int n = f.nextInt();
			while(n-->0){
				if (f.next().equals("Frankie")) {
					fr-=f.nextDouble();
				}
				else{
					j-=f.nextDouble();
				}
			}
			if(fr==j){
				out.println("Expenditures match");
			}
			else{
				double diff =(int)(Math.abs(fr-j)/2 * 100 );
				if(fr>j){
					out.printf("Frankie gives Johnny %.2f\n",diff/100);
				}
				else{
					out.printf("Johnny gives Frankie %.2f\n", diff/100);
				}
			}
        }
        f.close();
    }
}
