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

public class bryan {
    public static void main(String[] args) throws Exception {
        new bryan().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bryan").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int t=1;t<=times;++t){
			int n = f.nextInt();
			int m = 0;
			for (int i = 0; i < n; i++) {
				f.next();
				m+=f.nextInt();
			}
			out.println("Case #" + t + ": " +(m > 0?"Wow, Bryan saved $" + m : (m == 0 ? "Phew, broke even!":"Oh no! Bryan had to borrow $" + Math.abs(m))));
        }
        f.close();
    }
}
