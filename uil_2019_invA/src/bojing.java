import java.util.*;
import java.io.*;

public class bojing {
    public static void main(String[] args) throws Exception {
        new bojing().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("bojing.dat"));
        //Scanner f = new Scanner(System.in);
        Map<Integer,Set<String>> tm =new TreeMap<>();
		while(f.hasNext()){
			String[] l = f.nextLine().split("\\s+");
			for (int i = 0; i < l.length; i++) {
				tm.putIfAbsent(l[i].length(),new TreeSet<>());
				tm.get(l[i].length()).add(l[i]);
			}
		}
		for(Integer l : tm.keySet()){
			for(String s : tm.get(l)){
				System.out.print(s + " ");
			}
			System.out.println();
		}
        f.close();
    }
}
