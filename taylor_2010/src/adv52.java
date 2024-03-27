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

public class adv52 {
    public static void main(String[] args) throws Exception {
        new adv52().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("adv52").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			double m = f.nextDouble() + f.nextDouble() + f.nextDouble();
			double pay = 20;
			while(pay < m){
				pay+=20;
			}
			out.printf("$%.2f $%.2f\n",pay, pay - m);
		}
        f.close();
    }
}