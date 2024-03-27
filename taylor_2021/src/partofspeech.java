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

public class partofspeech {
    public static void main(String[] args) throws Exception {
        new partofspeech().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("partofspeech.dat"));
        //Scanner f = new Scanner(System.in);
		List<String> noun = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
		List<String> verb = new ArrayList<>();
		verb.addAll(Arrays.asList(f.nextLine().split("\\s+")));
		verb.addAll(Arrays.asList(f.nextLine().split("\\s+")));
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			String s = f.next().toLowerCase();
			int N =f.nextInt();
			f.nextLine();
			for (int i = 0; i < N; i++) {
				Scanner line = new Scanner(f.nextLine());
				List<String> al = new ArrayList<>();
				while(line.hasNext()){
					al.add(line.next().toLowerCase());
				}
				boolean n = false, v = false;
				if(noun.contains(al.get(al.indexOf(s)-1).toLowerCase())){
					n = true;
				}else if(verb.contains(al.get(al.indexOf(s)-1).toLowerCase())){
					v = true;
				}
				if(n && !v){
					out.println("NOUN");
				}else if(!n && v){
					out.println("VERB");
				}
			}
			out.println();
        }
        f.close();
    }
}
