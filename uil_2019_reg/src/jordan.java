import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class jordan {
    public static void main(String[] args) throws Exception {
        new jordan().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("jordan").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			long a = Long.parseLong(f.next(),17), b = Long.parseLong(f.next(),17), t = Long.parseLong(f.next(),17);
			List<Long> al = new ArrayList<>();
			al.add(a);
			al.add(b);
			while(al.get(al.size() - 1) < t){
				al.add(al.get(al.size()-1) + al.get(al.size()-2));
			}
			if(al.get(al.size()-1).equals(t)){
				out.println(al.size());
			}
			else{
				String one = Long.toString(al.get(al.size()-2),17), two = Long.toString(al.get(al.size()-1),17);
				out.printf("%S %S\n",one,two);
			}
        }
        f.close();
    }
}
