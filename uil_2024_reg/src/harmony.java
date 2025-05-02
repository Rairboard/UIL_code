import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class harmony {
	String special;
    public static void main(String[] args) throws Exception {
        new harmony().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("harmony").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String rank = f.nextLine().toLowerCase().trim();
		special = f.nextLine().trim();
		HashSet<String> common = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			common.addAll(Arrays.asList(f.nextLine().trim().split(",")));
		}
		while(f.hasNext()){
			String ln = f.nextLine().trim();
			out.print(ln+":");
			int score = 0;
			int cnt = 0;
			boolean good = true;
			if(common.contains(ln)||ln.length()<8){
				score = 0;
				good = false;
			}
			if (ln.matches(".*[a-z].*")) cnt++;
			if(ln.matches(".*[A-Z].*")) cnt++;
			if(ln.matches(".*[0-9].*")) cnt++;
			for (int i = 0; i < ln.length(); i++) {
				if (special.contains(ln.charAt(i)+"")){
					cnt++;
					break;
				}
			}
			if(!good || cnt < 3){
				out.println(score+":UNACCEPTABLE");
			}
			else{
				if(ln.length()>10) score+= 3 * (ln.length()-10);
				if(cnt==4) score+=5;
				for (int i = 0; i < ln.length(); i++) {
					if(ln.substring(i,i+1).matches("[0-9]")) score+=3;
					if(special.contains(ln.charAt(i)+"")) score+=5;
					int ind = rank.indexOf(ln.substring(i,i+1).toLowerCase());
					if(ind>=0 && ind < rank.length()/2) score++;
					if(ind>=rank.length()/2) score+=3;
				}
				for (int i = 0; i < ln.length()-1; i++) {
					int a = category(ln.substring(i,i+1));
					int b = category(ln.substring(i+1,i+2));
					if(a!=b) score+=3;
					if(ln.charAt(i)==ln.charAt(i+1)) score-=2;
				}
				if(score>=51) out.println(score + ":STRONG");
				else if(score>=36) out.println(score+":GOOD");
				else if(score>=21) out.println(score+":FAIR");
				else if(score>=1) out.println(score+":WEAK");
				else out.println(score+":UNACCEPTABLE");
			}
		}
        f.close();
    }
	public int category(String s){
		if(s.matches("[0-9]")) return 0;
		if(s.matches("[a-z]")) return 1;
		if(s.matches("[A-Z]")) return 2;
		if(special.contains(s)) return 3;
		return -1;
	}
}
