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

public class ariana {
    public static void main(String[] args) throws Exception {
        new ariana().run();
    }

    public void run() throws Exception {
        List<String> al = new ArrayList<>(Arrays.asList("i must not tell lies.".split("\\s+")));
		int in = 0;
		boolean up = true;
		for (int i = 0; i < 40; i++) {
			out.printf("%-3d",i+1);
			String ln = "";
			for (int j = 0; j < al.size(); j++) {
				if(j==in){
					ln+=al.get(j).toUpperCase() + " ";
				}else{
					ln+=al.get(j) + " ";
				}
			}
			out.println(ln.trim());
			if(in == al.size()-1){
				up = false;
			}
			else if(in == 0){
				up = true;
			}
			if(up){
				in++;
			}
			else{
				in--;
			}
		}
    }
}
