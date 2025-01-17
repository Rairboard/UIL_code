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

public class mandms {
    public static void main(String[] args) throws Exception {
        new mandms().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("mandms").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int m =f.nextInt();
			int cnt = 0;
			while(m>0){
				if(m%2==1){
					m-=1;
				}
				else{
					if(m/2 > 1){
						m-= (m/2-1) * 2;
					}
					else{
						m-=1;
					}
				}
				cnt++;
			}
			out.println(cnt);
        }
        f.close();
    }
}
