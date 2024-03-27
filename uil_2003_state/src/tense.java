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

public class tense {
    public static void main(String[] args) throws Exception {
        new tense().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("tense").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			String[] ln = f.nextLine().split("\\.");
			Set<String> verb = new LinkedHashSet<>();
			for (int i = 0; i < ln.length; i++) {
				boolean found = false;
				String[] sen = ln[i].split("\\s+");
				for (int j = 0; j < sen.length; j++) {
					if(sen[j].equalsIgnoreCase("will")){
						if(j+1<sen.length){
							if(sen[j+1].matches(".*[Ee][Dd]") || !sen[j+1].equalsIgnoreCase("have")){
								found = true;
								verb.add(sen[j]+" " + sen[j+1]);
								j++;
							}
						}
					}
					else if(sen[j].equalsIgnoreCase("have")){
						if(j+1<sen.length && sen[j+1].matches(".*([Ee][Dd])") && j-1 >-1 && !sen[j-1].equalsIgnoreCase("will")){
							verb.add(sen[j]+" " + sen[j+1]);
							found =true;
							j++;
						}
					}
					else if(sen[j].matches(".*([Ee][Dd])") && j -1  >-1 && !sen[j-1].equalsIgnoreCase("have")){
						verb.add(sen[j]);
						found = true;
					}
					else if(sen[j].matches(".*([Ii][Nn][Gg])") && j-1>-1){
						verb.add(sen[j-1] + " " + sen[j]);
						found = true;
					}
				}
			}
			List<String> al =new ArrayList<>(verb);
			for (int i = 0; i < al.size(); i++) {
				out.print(al.get(i));
				if(i<al.size()-1){
					out.print(",");
				}
			}
			out.println();
		}
        f.close();
    }
}
