import java.util.*;
import java.io.*;
public class Boxing {
	public static void main(String[] args)throws Exception {
		new Boxing().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Boxing.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String ln = f.nextLine();
            int n = 2 * ln.length()-1;
            char[][] m = new char[n][n];
            int index = 0;
            for (int j = 0; j < ln.length(); j++) {
                int top = j, left = j, right = n-1-j, bottom = n-1-j;
                for(int i = left;i<=right;i++){
                    m[top][i] = ln.charAt(index);
                    m[bottom][i] = ln.charAt(index);
                }
                if(index==ln.length()-1) break;
                for(int i = top;i<=bottom;i++){
                    m[i][right] = ln.charAt(index);
                    m[i][left] = ln.charAt(index);
                }
                index++;
            }
            for(char[] line : m){
                System.out.println(line);
            }
            System.out.println("^".repeat(5));
        }
        f.close();
	}
}
