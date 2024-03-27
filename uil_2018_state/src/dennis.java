import java.util.*;
import java.io.*;

public class dennis {
    public static void main(String[] args) throws Exception {
        new dennis().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("dennis.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int N = f.nextInt();
            int row = Integer.MIN_VALUE;
            List<String> al = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String s =f.next();
                al.add(s);
                row = Math.max(row,s.length());
            }
            char[][] m = new char[row][N];
            for(int c = 0; c < N;c++){
                for(int r= 0; r < row;r++){
                    try{
                        m[r][c] = al.get(c).charAt(r);
                    }
                    catch(Exception e){
                        m[r][c] = ' ';
                    }
                }
            }
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i]);
            }
            System.out.println("*".repeat(N));
        }
        f.close();
    }
}
