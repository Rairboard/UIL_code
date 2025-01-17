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

public class christine {
    public static void main(String[] args) throws Exception {
        new christine().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("christine").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		int a =f.nextInt(), b = f.nextInt(), c = f.nextInt(), d = f.nextInt(), e = f.nextInt(), ff = f.nextInt();
		if(a<=b){
			for(int i = a; i <= b;i++){
				out.print(i+ " ");
			}
			out.println();
		}
		else{
			for(int i = a; i >= b;i--){
				out.print(i+ " ");
			}
			out.println();
		}
		if(b<=c){
			for(int i = b; i <= c;i++){
				out.print(i+ " ");
			}
			out.println();
		}
		else{
			for(int i = b; i >= c;i--){
				out.print(i+ " ");
			}
			out.println();
		}
		if(c<=d){
			for(int i = c; i <= d;i++){
				out.print(i+ " ");
			}
			out.println();
		}
		else{
			for(int i = c; i >= d;i--){
				out.print(i+ " ");
			}
			out.println();
		}
		if(d<=e){
			for(int i = d; i <= e;i++){
				out.print(i+ " ");
			}
			out.println();
		}
		else{
			for(int i = d; i >= e;i--){
				out.print(i+ " ");
			}
			out.println();
		}
		if(e<=ff){
			for(int i = e; i <= ff;i++){
				out.print(i+ " ");
			}
			out.println();
		}
		else{
			for(int i = e; i >= ff;i--){
				out.print(i+ " ");
			}
			out.println();
		}
        f.close();
    }
}
