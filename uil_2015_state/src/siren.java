import java.util.*;
import java.io.*;
public class siren {
	public static void main(String[] args)throws Exception {
		new siren().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("siren.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int n = f.nextInt(), w = f.nextInt();
            List<int[]> siren = new ArrayList<>();
            boolean[][] connected = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                siren.add(new int[]{f.nextInt(),f.nextInt(),f.nextInt()});
            }
            for (int i = 0; i < n; i++) {
                for(int j = i + 1;j < n;j++){
                    double dis = Math.sqrt(Math.pow(siren.get(i)[0] - siren.get(j)[0], 2) + Math.pow(siren.get(i)[1] - siren.get(j)[1],2));
                    if(dis <=siren.get(i)[2] + siren.get(j)[2]){
                        connected[i][j] = connected[j][i] = true;
                    }
                }
            }
//            for(boolean[] ar : connected){
//                System.out.println(Arrays.toString(ar));
//            }
            boolean[] visited = new boolean[n];
            Queue<int[]> q = new LinkedList<>();
            for(int i =0 ;i < n;i++){
                if(Math.abs(siren.get(i)[1]) <= siren.get(i)[2]){
                    q.offer(new int[]{siren.get(i)[0], siren.get(i)[1], siren.get(i)[2], i});
                    visited[i] = true;
                }
            }
            boolean good = true;
            while(!q.isEmpty()){
                int[]cur = q.remove();
                int u = cur[3];
                if(Math.abs(w - cur[1]) <= cur[2]){
                    good = false;
                    break;
                }
                for (int i = 0; i < connected[u].length; i++) {
                    if(connected[u][i] && !visited[i]){
                        visited[i] = true;
                        q.offer(new int[]{siren.get(i)[0], siren.get(i)[1], siren.get(i)[2], i});
                    }
                }
            }
            if(good) System.out.println("YES");
            else System.out.println("NO");
        }
        f.close();
	}
}
