import java.util.*;
import java.io.*;

public class chongan {
    public static void main(String[] args) throws Exception {
        new chongan().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("chongan.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
		f.nextLine();
        for (int i = 0; i < times; i++) {
			int max = Integer.MIN_VALUE;
			String save = "";
			Scanner line = new Scanner(f.nextLine());
			while(line.hasNext()){
				String w = line.next();
				int N = line.nextInt();
				if(N > max){
					max = Math.max(max,N);
					save = w;
				}
			}
			System.out.println(save);
        }
        f.close();
    }
}
