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

public class sketch {
    public static void main(String[] args) throws Exception {
        new sketch().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sketch").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		String ch = "!@#$%&";
		while(f.hasNext()){
			int shape = f.nextInt(), dm = f.nextInt(), in = f.nextInt();
			boolean b = f.nextBoolean();
			f.nextLine();
			if(shape==0){
				for (int i = 0; i < dm; i++) {
					for (int j = 0; j < dm; j++) {
						if(i > 0 && i < dm -1 && j > 0 && j < dm-1 && !b){
							out.print(" ");
						}
						else{
							out.print(ch.charAt(in));
						}
					}
					out.println();
				}
			}
			else if(shape==1){
				for (int i = 0; i < dm; i++) {
					for (int j = 0; j < dm-i; j++) {
						if(i > 0 && i < dm - 1 && j > 0 && j < dm - i - 1 && !b){
							out.print(" ");
						}
						else{
							out.print(ch.charAt(in));
						}
					}
					out.println();
				}
			}
			else if(shape == 2){
				for (int i = 0; i < dm; i++) {
					for (int j = 0; j < dm; j++) {
						if(j < i){
							out.print(" ");
						}
						else if( i > 0 && i < dm - 1 && j > i && j < dm - 1 && !b){
							out.print(" ");
						}
						else{
							out.print(ch.charAt(in));
						}
					}
					out.println();
				}
			}
			else if(shape == 3){
				for (int i = 0; i < dm; i++) {
					for (int j = 0; j <= i; j++) {
						if(i > 0 && i < dm - 1 && j > 0 && j < i&& !b ){
							out.print(" ");
						}
						else{
							out.print(ch.charAt(in));
						}
					}
					out.println();
				}
			}
			else if(shape == 4){
				for (int i = 0; i < dm; i++) {
					for (int j = 0; j < dm; j++) {
						if(j < dm - 1 - i ){
							out.print(" ");
						} else if (i > 0 && i < dm - 1 && j > dm - i - 1 && j < dm - 1 && !b){
							out.print(" ");
						}
						else{
							out.print(ch.charAt(in));
						}
					}
					out.println();
				}
			}
        }
        f.close();
    }
}
