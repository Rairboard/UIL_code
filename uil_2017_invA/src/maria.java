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

public class maria {
    public static void main(String[] args) throws Exception {
        new maria().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("maria.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			int N = f.nextInt();
			if(N==1){
				out.println("---\n-*-\n---");
			}
			if(N==2){
				out.println("*--\n---\n--*");
			}
			if(N==3){
				out.println("*--\n-*-\n--*");
			}
			if(N==4){
				out.println("*-*\n---\n*-*");
			}
			if(N==5){
				out.println("*-*\n-*-\n*-*");
			}
			if(N==6){
				out.println("*-*\n*-*\n*-*");
			}
			out.println();
		}
        f.close();
    }
}
