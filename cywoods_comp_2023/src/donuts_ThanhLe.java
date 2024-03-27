import java.util.*;
import java.io.File;

public class donuts_ThanhLe {
    public static void main(String[] args) throws Exception {
        new donuts_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("donuts.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r = f.nextInt(), c = f.nextInt();
            char[][] m = new char[r][c];
            boolean[][] v = new boolean[r][c];
            f.nextLine();
            for (int i = 0; i < m.length; i++) {
                Arrays.fill(v[i],false);
                m[i] = f.nextLine().toCharArray();
            }
//            for(char[] c : m){
//                System.out.println(c);
//            }
            int top = 0, left = 0, right = m[0].length-1, bottom = m.length-1;
            String ln = "";
            while(left<=right && top <= bottom){
                for(int i = left;i<=right;i++){
                    if(!v[top][i]){
                        ln += m[top][i];
                        v[top][i] = true;
                    }
                }
                top++;
//                if(left>=right && top >= bottom){
//                    break;
//                }
                for(int i = top;i<=bottom;i++){
                    if(!v[i][right]){
                        ln += m[i][right];
                        v[i][right] = true;
                    }
                }
                right--;
                for(int i = right;i >=left;i--){
                    if(!v[bottom][i]){
                        ln += m[bottom][i];
                        v[bottom][i] = true;
                    }
                }
                bottom--;
                for(int i = bottom;i>=top;i--){
                    if(!v[i][left]){
                        ln += m[i][left];
                        v[i][left] = true;
                    }
                }
                left++;
            }
            System.out.println(ln);
        }
        f.close();
    }
}
