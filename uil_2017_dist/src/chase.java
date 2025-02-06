import java.util.*;
import java.io.File;

public class chase {
    public static void main(String[] args) throws Exception {
        System.out.println(Integer.toBinaryString(-6));
        System.out.println(Integer.toBinaryString(-6>>>31));
        System.out.println(-6>>2);
//        new chase().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("chase").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            if(f.hasNext())f.nextLine();
            char[][] m = new char[n][n];
            List<int[]> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                m[i] = f.nextLine().trim().toCharArray();
                for (int j = 0; j < n; j++) {
                    if(m[i][j]=='&') al.add(new int[]{i,j});
                }
            }
            for(int[] p : al){
                int r = p[0], c = p[1];
                for(int i = r-1;i<=r+1;i++){
                    for(int j = c-1;j<=c+1;j++){
                        if(i>=0&&i<n&&j>=0&&j<m[i].length) m[i][j] = '$';
                    }
                }
            }
            for(char[] line : m){
                System.out.println(line);
            }
            System.out.println();
        }
        f.close();
    }
}
