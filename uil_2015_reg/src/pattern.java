import java.util.*;
import java.io.*;
public class pattern {
	public static void main(String[] args)throws Exception {
		new pattern().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("pattern.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            Map<String,HashSet<String>> a = new HashMap<>(), b = new HashMap<>();
            boolean good = true;
            String ln = f.nextLine().trim();
            String[] line = f.nextLine().trim().split("\\s+");
            for (int i = 0; i < line.length; i++) {
                a.putIfAbsent(ln.substring(i,i+1), new HashSet<>());
                b.putIfAbsent(line[i], new HashSet<>());
                a.get(ln.substring(i,i+1)).add(line[i]);
                b.get(line[i]).add(ln.substring(i,i+1));
            }
            for(String s : a.keySet()){
                if(a.get(s).size() > 1){
                    good = false;
                    break;
                }
            }
            if(good){
                for(String s : b.keySet()){
                    if(b.get(s).size() > 1){
                        good = false;
                        break;
                    }
                }
            }
            if(ln.length() != line.length) good = false;
            System.out.println(good ? "Matches":"Does Not Match");
        }
        f.close();
	}
}
