import java.util.*;
import java.io.*;
class juana{
    int[][] m;
    public static void main(String[] args) throws FileNotFoundException {
        new juana().run();
    }
    public void run () throws FileNotFoundException {
        // Scanner f = new Scanner(System.in);
        Scanner f = new Scanner(new File("juana.dat"));
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1; asdf <= times;asdf++){
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            m = new int[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            int sr = f.nextInt() -1, sc = f.nextInt()-1, C = f.nextInt(), R = f.nextInt();
            if(sr>=0&&sc>=0 && (sr + R <= row && sc + C <= col)){
                System.out.println("Test case #" + asdf + ":");
                for(int i = sr;i<sr + R;i++){
                    for(int j = sc;j<sc+C;j++){
                        System.out.printf("%5d", m[i][j]);
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("Test case #"+asdf+": Unable to extract requested size!");
            }
            System.out.println("-".repeat(20));
        }
    }
}
