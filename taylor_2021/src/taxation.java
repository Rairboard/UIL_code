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

public class taxation {
    public static void main(String[] args) throws Exception {
        new taxation().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("taxation.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
		double sum = 0;
        f.nextLine();
        while (times-- > 0) {
			try{
				sum+=f.nextDouble();
			}catch(Exception e){
				f.next();
				double d  =f.nextDouble();
				sum+= d + (d*.0825);
			}
        }
		out.printf("The total is $%.2f",sum);
        f.close();
    }
}
