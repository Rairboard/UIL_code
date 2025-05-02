import java.util.*;
import java.io.*;
public class rashi {
    double[][][] m;
    double sum;
    int cnt;
	public static void main(String[] args)throws Exception {
		new rashi().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("rashi.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String[] data = f.nextLine().trim().split(",");
            int level = Integer.parseInt(data[0]), row = Integer.parseInt(data[1]), col = Integer.parseInt(data[2]);
            m = new double[level][row][col];
            for (int i = 0; i < level; i++) {
                for (int j = 0; j < row; j++) {
                    m[i][j] = Arrays.stream(f.nextLine().trim().split(",")).mapToDouble(Double::parseDouble).toArray();
                }
            }
            List<Double> al = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                for (int j = 0; j < row; j++) {
                    for (int k = 0; k < col; k++) {
                        if(m[i][j][k] > 0){
                            sum = 0;
                            cnt = 0;
                            recur(i,j,k);
                            if(cnt>1) al.add(sum);
                        }
                    }
                }
            }
            Collections.sort(al);
            System.out.println("TEST CASE #" +asdf + ":");
            if(al.isEmpty()) System.out.println("NO CLUSTERS FOUND");
            else{
                for(int i = al.size()-1;i>=0;i--){
                    System.out.printf("%.2f\n", al.get(i));
                }
            }
            System.out.println("=".repeat(12));
        }
        f.close();
	}
    public void recur(int l, int r, int c){
        if(l>=0&&r>=0&&c>=0&&l<m.length&&r<m[l].length&&c<m[l][r].length&&m[l][r][c]>0){
            sum+=m[l][r][c];
            m[l][r][c] = 0;
            cnt++;
            recur(l-1,r,c);
            recur(l+1,r,c);
            recur(l,r-1,c);
            recur(l,r+1,c);
            recur(l,r,c-1);
            recur(l,r,c+1);
        }
    }
}
