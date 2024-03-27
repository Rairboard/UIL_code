import java.util.*;
import java.io.*;

public class arusha {
    public static void main(String[] args) throws Exception {
        new arusha().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("arusha.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
			List<String> al = new ArrayList<>(Arrays.asList(f.next().split("")));
			String rot = f.next();
			for (int i = 0; i < rot.length(); i++) {
				if(rot.charAt(i) == 'L'){
					al.add(al.remove(0));
				}
				else if (rot.charAt(i) == 'R'){
					al.add(0,al.remove(al.size()-1));
				}
			}
			al.forEach(e -> System.out.print(e));
			System.out.println();
        }
        f.close();
    }
}
