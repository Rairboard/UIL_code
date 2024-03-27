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

public class patricia {
    public static void main(String[] args) throws Exception {
        new patricia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("patricia.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int N = f.nextInt(), red = f.nextInt(), green = f.nextInt(), total = red + green;
			int n = 1, d = 1;
			boolean putBack = false;
			List<Character> move = new ArrayList<>();
			if(N==2){
				if(f.next().charAt(0)=='Y'){
					putBack = true;
				}
			}
			for (int i = 0; i < N; i++) {
				move.add(f.next().charAt(0));
			}
			for (int i = 0; i < move.size(); i++) {
				switch(move.get(i)){
					case 'R': n *=red;d*=total;break;
					case 'G': n *= green;d*=total;break;
				}
				if(N==2){
					if(!putBack){
						total--;
					}
				}
			}
			out.println(n+"/"+d);
        }
        f.close();
    }
}
