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

public class stock {
    public static void main(String[] args) throws Exception {
        new stock().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("stock").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt();
			out.println(f.nextLine().trim());
			long[] stock = new long[n];
			for (int i = 0; i < n; i++) {
				stock[i] = f.nextLong();
			}
			for (int i = 0; i < n; i++) {
				int j = i+1;
				if(j < n){
					if(stock[j] < stock[i]){
						out.println(i+1 + " SELL");
						while(j < n && stock[j] < stock[j-1]) j++;
						i = j-2;
					}
					else{
						out.println(i+1 + " BUY");
						while (j < n && stock[j] > stock[j-1]) j++;
						i = j - 2;
					}
				}
				else{
					if(stock[i] > stock[i-1]){
						out.println(i + 1 + " SELL");
					}
					else{
						out.println(i + 1 + " BUY");
					}
				}
			}
        }
        f.close();
    }
}
