import java.util.*;
import java.io.*;
public class minutes {
	public static void main(String[] args)throws Exception {
		new minutes().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("minutes.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String[] ln = f.nextLine().trim().split("\\s+");
            String name = ln[0];
            long total = 0;
            for(int i = 2;i<ln.length;i+=4){
                String[] in = ln[i].split(":");
                String[] out = ln[i+2].split(":");
                long a = Long.parseLong(in[0]) * 60 + Long.parseLong(in[1]);
                long b = Long.parseLong(out[0]) * 60 + Long.parseLong(out[1]);
                if (ln[i - 1].equals(ln[i + 1])) {
                    total+=a-b;
                }
                else{
                    int numQuarter = Integer.parseInt(ln[i+1].substring(1)) - Integer.parseInt(ln[i-1].substring(1)) - 1;
                    total += a + numQuarter * 720L + (720 - b);
                }
            }
            System.out.printf("%s %d:%02d\n", name, total/60, total%60);
        }
        f.close();
	}
}
