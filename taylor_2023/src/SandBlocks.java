import java.util.*;
import java.io.*;

public class SandBlocks {
    public static void main(String[] args) throws Exception {
        new SandBlocks().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("SandBlocks.in"));
        //Scanner f = new Scanner(System.in);
        int r =f.nextInt(),c = f.nextInt();
		f.nextLine();
		char[][] m  = new char[r][c];
		for (int i = 0; i < r; i++) {
			m[i] = f.nextLine().toCharArray();
		}
		for (int j = 0; j < c; j++) {
			String block = "";
			for(int i = m.length-1;i>-1;i--){
				block += m[i][j];
			}
			int one = block.length() - block.replaceAll("1","").length();
			int zero = block.length() - one;
			block =  "0".repeat(zero) + "1".repeat(one);
			for(int i = m.length-1;i>-1;i--){
				m[i][j] = block.charAt(i);
			}
		}
		for (int i = 0; i < m.length; i++) {
			System.out.println(new String(m[i]));
		}
        f.close();
    }
}
