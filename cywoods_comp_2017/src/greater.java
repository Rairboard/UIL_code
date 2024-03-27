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

public class greater {
    public static void main(String[] args) throws Exception {
        new greater().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("greater").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			String[] a = f.nextLine().split("\\s+");
			String[] b = f.nextLine().split("\\s+");
			long first = Long.parseLong(a[a.length-1]);
			long sec = Long.parseLong(b[b.length-1]);
			String name1 = "", name2 ="";
			for (int i = 0; i < a.length - 1; i++) {
				name1+=a[i] + " ";
			}
			for (int i = 0; i < b.length - 1; i++) {
				name2+=b[i]+" ";
			}
			name1 = name1.trim();
			name2 = name2.trim();
			if(first == 8 && sec == 5 || first == 5 && sec == 8){
				if(first == 5 && sec == 8){
					out.println(name1 + " > " + name2);
				}
				if(first == 8 && sec == 5){
					out.println(name1 + " < " + name2);
				}
			}
			else{
				if(first == sec){
					out.println(name1 + " = " + name2);
				}
				if(first > sec){
					out.println(name1 + " > " + name2);
				}
				if(first < sec){
					out.println(name1 + " < " + name2);
				}
			}
        }
        f.close();
    }
}
