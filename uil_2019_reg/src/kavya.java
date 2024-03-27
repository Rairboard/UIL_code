import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class kavya {
    public static void main(String[] args) throws Exception {
        new kavya().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("kavya").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			String ln = f.nextLine().toUpperCase().replaceAll("[^A-Z]","");
			Map<String,Integer> cnt = new LinkedHashMap<>();
			Map<Integer,List<String>> tm = new TreeMap<>(Collections.reverseOrder());
			for (int i = 0; i < ln.length(); i++) {
				cnt.put(ln.substring(i,i+1),cnt.getOrDefault(ln.substring(i,i+1),0)+1);
			}
			for(String s : cnt.keySet()){
				tm.putIfAbsent(cnt.get(s), new ArrayList<>());
				tm.get(cnt.get(s)).add(s);
			}
			for(Integer i : tm.keySet()){
				for(String s : tm.get(i)){
					out.print(s.repeat(i));
				}
			}
			out.println();
		}
        f.close();
    }
}
