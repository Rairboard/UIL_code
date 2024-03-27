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

public class weirdChange {
    public static void main(String[] args) throws Exception {
        new weirdChange().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("weirdChange.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			int N = f.nextInt();
			double money = N*3/100.0;
			int[] coin = {1,5,13,23,37,47};
			int[] used = new int[coin.length];
			for(int i=coin.length-1;i>-1;i--){
				if(N>=coin[i]){
					used[i] = N/coin[i];
					N%=coin[i];
				}
			}
			out.printf("$%.2f ",money);
			for(int i=used.length-1;i>-1;i--){
				out.print(used[i] + " ");
			}
			out.println();
		}
        f.close();
    }
}
