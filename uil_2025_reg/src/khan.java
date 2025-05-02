import java.util.*;
import java.io.*;
public class khan {
	public static void main(String[] args)throws Exception {
		new khan().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("khan.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int n = f.nextInt();
            long W = f.nextLong();
            double[][] m = new double[n][3];
            for (int i = 0; i < n; i++) {
                m[i] = new double[]{f.nextDouble(), f.nextDouble(), f.nextDouble()};
            }
            boolean[] leftBorder = new boolean[n];
            boolean[] rightBorder = new boolean[n];
            for(int i = 0;i < n;i++){
                if(Math.abs(m[i][0]) <= m[i][2]){
                    leftBorder[i] = true;
                }
                if(Math.abs(W - m[i][0]) <= m[i][2]){
                    rightBorder[i] = true;
                }
            }
            long l = 0, r = n;
            while(l < r){
                long mid = (l + r + 1) >> 1;
                DSU dsu = new DSU(n);
                for(int i = 0;i <= mid && i < n;i++){
                    for(int j = i+1;j<=mid && j < n ;j++){
                        double dis = Math.sqrt(Math.pow(m[i][0] - m[j][0], 2) + Math.pow(m[i][1] - m[j][1],2));
                        if(dis <= m[i][2] + m[j][2]){
                            int ahead = dsu.find(i);
                            int bhead = dsu.find(j);
                            if(ahead!=bhead){
                                dsu.union(ahead, bhead);
                            }
                        }
                    }
                }
                boolean good = false;
                for (int i = 0; i < n; i++) {
                    if(leftBorder[dsu.find(i)] && rightBorder[dsu.find(i)]){
                        good = true;
                        break;
                    }
                }
                if(good) l = mid;
                else r = mid-1;
            }
            if(l==n) System.out.println("Completely Undetected.");
            else System.out.println(l);
        }
        f.close();
	}
    class DSU{
        int[] parent;
        public DSU(int n){
            parent = new int[n];
            Arrays.fill(parent, -1);
        }
        public int find(int i){
            if(parent[i] == -1) return i;
            return parent[i] = find(parent[i]);
        }
        public void union(int a, int b){
            parent[a] = b;
        }
    }
}
