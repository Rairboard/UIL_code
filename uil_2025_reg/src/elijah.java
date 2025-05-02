import java.util.*;
import java.io.*;
public class elijah {
	public static void main(String[] args)throws Exception {
		new elijah().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("elijah.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            char[][] m = new char[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().trim().toCharArray();
            }
            long rotation = f.nextLong()/ 90 % 4;
            for (int i = 0; i < rotation; i++) {
                char[][] copy = new char[m[0].length][m.length];
                for (int j = 0; j < m[0].length; j++) {
                    for (int k = 0; k < m.length; k++) {
                        copy[j][k] = m[m.length-1-k][j];
                    }
                }
                m = copy;
            }
            for(char[] each : m){
                System.out.println(each);
            }
            if(asdf < times) System.out.println();
        }
        f.close();
	}
}
