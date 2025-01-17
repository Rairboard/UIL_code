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

public class candy {
    public static void main(String[] args) throws Exception {
        new candy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("candy").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt(), k =f.nextInt();
			int cnt = 0;
			for (int i = 0; i < k; i++) {
				if(f.nextInt()%n==0){
					cnt++;
				}
			}
			out.println(cnt);
        }
        f.close();
    }
}
