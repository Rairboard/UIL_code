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

public class crosswordclues {
    public static void main(String[] args) throws Exception {
        new crosswordclues().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("crosswordclues.dat"));
        //Scanner f = new Scanner(System.in);
		List<String> al = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			al.addAll(Arrays.asList(f.nextLine().split("\\s+")));
		}
        while (f.hasNext()) {
			String s = f.next().replaceAll("\\*",".");
			String res = "";
			for (int i = 0; i < al.size(); i++) {
				if(al.get(i).matches(s)){
					res += al.get(i) + " ";
				}
			}
			if(res.length()!=0){
				out.println(res.trim());
			}else{
				out.println("NO MATCH");
			}
        }
        f.close();
    }
}
