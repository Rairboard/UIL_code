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

public class boxes {
    public static void main(String[] args) throws Exception {
        new boxes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("boxes").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int b = f.nextInt(), fit = 0;
			f.nextLine();
			String[] ln = f.nextLine().split("\\s+");
			for (int i = 0; i < ln.length - 1; i++) {
				String dimen = ln[i].replaceAll("[^0-9]","");
				String next = ln[i+1].replaceAll("[^0-9]","");
				if(permu(dimen,"",next)){
					fit++;
				}
				else{
					break;
				}
			}
			out.println(fit);
        }
        f.close();
    }
	public boolean permu(String orig, String ans, String s){
		if(orig.isEmpty() && ans.length() == s.length()){
			for (int i = 0; i < ans.length(); i++) {
				if(Integer.parseInt(ans.substring(i,i+1)) >= Integer.parseInt(s.substring(i,i+1))){
					return false;
				}
			}
			return true;
		}
		for(int i=0;i<orig.length();i++){
			if(permu(orig.substring(0,i) + orig.substring(i+1), ans + orig.charAt(i),s)){
				return true;
			}
		}
		return false;
	}
}
