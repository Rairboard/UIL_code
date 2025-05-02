import java.util.*;
import java.io.*;
public class land {
	public static void main(String[] args)throws Exception {
		new land().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("land.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            long[][] m = new long[row][col];
            long totalLandSofar = 0;
            int sr = -1, sc = -1;
            Map<Long,Long> count = new TreeMap<>();
            for (int i = 0; i < row; i++) {
                m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
                for (int j = 0; j < col; j++) {
                    count.put(m[i][j], count.getOrDefault(m[i][j],0L)+1);
                    if(m[i][j]==0){
                        sr = i;
                        sc =j;
                    }
                }
            }
            List<Long> al = new ArrayList<>();
            for(long each : count.keySet()){
                count.put(each, count.get(each) + totalLandSofar);
                totalLandSofar=count.get(each);
                al.add(each);
            }
            int i = 0, j = al.size()-1;
            int index = j;
            while(i <= j){
                int mid = i + (j-i)/2;
                Stack<Integer> q = new Stack<>();
                q.add(sr * col + sc);
                HashSet<Integer> visited = new HashSet<>();
                visited.add(sr * col + sc);
                while(!q.isEmpty()){
                    int cur = q.pop();
                    int r = cur / col;
                    int c = cur % col;
                    for (int k = 0; k < 4; k++) {
                        int nr = r + vr[k];
                        int nc = c + vc[k];
                        int newIndex = nr * col + nc;
                        if(in(nr,nc,row,col) && m[nr][nc] - al.get(mid) <= 0 && !visited.contains(newIndex)){
                            visited.add(newIndex);
                            q.add(newIndex);
                        }
                    }
                }
                if(visited.size() == count.get(al.get(mid))){
                    index = mid;
                    j = mid-1;
                }
                else i = mid+1;
            }
            System.out.println(al.get(index));
        }
        f.close();
	}
    int[] vr = {-1,1,0,0};
    int[] vc = {0,0,-1,1};
    public boolean in(int r, int c, int row, int col){
        return r>=0&&c>=0&&r<row&&c<col;
    }
}
