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

public class base {
    public static void main(String[] args) throws Exception {
        new base().run();
    }

    public void run() throws Exception {
		List<Integer> fact = new ArrayList<>();
		fact.add(1);
		fact.add(2);
		while(true){
			fact.add(fact.get(fact.size()-1) + fact.get(fact.size()-2));
			if(fact.getLast() >=1000) break;
		}
		if(fact.getLast()>=1000){
			fact.removeLast();
		}
//		out.println(fact);
        Scanner f = new Scanner(new File(("base").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			int n = f.nextInt();
			int index;
			for(index = fact.size()-1;index>-1;index--){
				if(n>=fact.get(index))break;
			}
			if(fact.get(index)==n) out.println(n + " = " + n);
			else{
				out.print(n + " = ");
				List<Integer> used = new ArrayList<>();
				while(n>0 && index>-1){
					if(n>=fact.get(index)){
						n-=fact.get(index);
						used.add(fact.get(index));
					}
					index--;
				}
				for(int i = 0;i<used.size();i++){
					if (i < used.size() - 1) {
						out.print(used.get(i)+" + ");
					}
					else{
						out.print(used.get(i));
					}
				}
				out.println();
			}
        }
        f.close();
    }
}
