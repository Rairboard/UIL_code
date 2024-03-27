import java.util.*;
import java.io.*;
public class test
{
	public static void main(String[] args)throws Exception {
		new test().run();
	}
	public void run() throws Exception{
//        Scanner f = new Scanner(new File("test.dat"));
      //Scanner f = new Scanner(System.in);
        Set<String> s = new LinkedHashSet<>();
        for (int i = 0; i < 10; i++) {
            s.add(Integer.toString(i));
        }
        System.out.println(new ArrayList<>(s).get(s.size()-1));
	}
}
