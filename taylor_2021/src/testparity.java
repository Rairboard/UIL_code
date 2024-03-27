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

public class testparity {
    public static void main(String[] args) throws Exception {
        new testparity().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("testparity.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			double N = f.nextDouble();
			if(N>100){
				N-=N*.1;
			}
			else if(N>75){
				N=N;
			}
			else if(N>50){
				N+=N*.25;
			}
			else if(N>25){
				N+=N*.5;
			}
			else if(N>0){
				N*=2;
			}
			out.print(Math.round(N) + " ");
		}
        f.close();
    }
}
