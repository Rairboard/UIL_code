import java.util.*;
import java.io.*;
public class Prob13 {
	public static void main(String[] args)throws Exception {
		new Prob13().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob13.in.txt"));
        //Scanner f = new Scanner(System.in);
        String[] cat = "Name,Age,Instagram,Twitter,Phone,Email".split(",");
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int n = f.nextInt();
            f.nextLine();
            String line = f.nextLine().trim();
            String[] info = line.substring(2,line.length()-2).split("],\\[");
            List<List<String>> al = new ArrayList<>();
            for (int i = 0; i < info.length; i++) {
                al.add(List.of(info[i].split(",")));
            }
            for (int i = 0; i < n; i++) {
                int index = al.get(0).indexOf(f.nextLine().trim());
                for (int j = 0; j < cat.length; j++) {
                    System.out.println(cat[j] + ": " + al.get(j).get(index));
                }
            }
        }
        f.close();
	}
}
