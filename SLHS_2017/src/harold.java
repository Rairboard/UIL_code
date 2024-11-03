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

public class harold {
    public static void main(String[] args) throws Exception {
        new harold().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("harold").toLowerCase() + ".in"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			double carmouche = f.nextDouble() * 5280.0 / 3600, harold = f.nextDouble() * 5280.0 / 3600;
			double dis = f.nextDouble();
			if(carmouche - harold <= 0){
				out.println("Oh No!");
			}
			else{
				out.printf("%.2f\n", dis / (carmouche - harold));
			}
        }
        f.close();
    }
}
