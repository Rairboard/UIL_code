import java.util.*;
import java.io.*;
public class emiliano {
	public static void main(String[] args)throws Exception {
		new emiliano().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("emiliano.dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            long ans = 0;
            int n = f.nextInt();
            f.nextLine();
            HashSet<String> words = new HashSet<>();
            for (int i = 0; i < n; i++) {
                words.add(f.nextLine().trim().toLowerCase());
            }
//            System.out.println(words);
            n = f.nextInt();
            f.nextLine();
            for (int i = 0; i < n; i++) {
                String ln = f.nextLine().trim().toLowerCase();
                for(int j = 1;j < ln.length();j++){
                    if(words.contains(ln.substring(0,j)) && words.contains(ln.substring(j))){
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
        f.close();
	}
}
