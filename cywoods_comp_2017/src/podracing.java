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

public class podracing {
    public static void main(String[] args) throws Exception {
        new podracing().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("podracing").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			if(f.nextLine().toLowerCase().matches(".*mos.*espa.*grand.*arena.*")){
				out.println("Now this is podracing!");
			}
			else{
				out.println("Oof! This is NOT podracing!");
			}
        }
        f.close();
    }
}
