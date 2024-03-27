import java.util.*;
import java.io.*;

public class lucy {
    public static void main(String[] args) throws Exception {
        new lucy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("lucy.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0){
			int N = f.nextInt();
			f.nextLine();
			while(N-->0){
				String line = f.nextLine();
				for (int j = 0; j < line.length(); j++) {
					int i=j;
					while(i+1 < line.length() && line.charAt(i)==line.charAt(i+1)){
						i++;
					}
					System.out.print(line.substring(i,i+1) + (i-j+1));
					j=i;
				}
				System.out.println();
			}
			System.out.println("=====");
        }
        f.close();
    }
}
