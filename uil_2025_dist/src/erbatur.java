import java.util.*;
import java.io.*;
public class erbatur{
    boolean reach;
    List<int[]> cord;
    char[][] m;
    public void run() throws FileNotFoundException{
        Scanner f = new Scanner(new File("erbatur".toLowerCase()+".dat"));
        //Scanner f = new Scanner(System.in);
        int[] vr = {-1,1,0,0};
        int[] vc = {0,0,-1,1};
        int times = f.nextInt();
        if(f.hasNext()) f.nextLine();
        while(times-->0){
            int row =f.nextInt();
            int col = f.nextInt();
            if(f.hasNext())f.nextLine();
            m = new char[row][col];
            long[][] count = new long[row][col];
            List<int[]> al = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                m[i]  =f.nextLine().trim().toCharArray();
                for (int j = 0; j < col; j++) {
                    if(m[i][j]=='#'){
                        al.add(new int[]{i,j});
                        count[i][j] = 4;
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(m[i][j]=='.'){
                        reach = false;
                        cord = new ArrayList<>();
                        Stack<Integer> q = new Stack<>();
                        q.add(i);
                        q.add(j);
                        while(!q.isEmpty()){
                            int c = q.pop();
                            int r = q.pop();
                            if(r==0||c==0||r==m.length-1||c==m[r].length-1){
                                reach = true;
                            }
                            cord.add(new int[]{r,c});
                            m[r][c] = '@';
                            for (int k = 0; k < 4; k++) {
                                int nr = r + vr[k];
                                int nc = c + vc[k];
                                if(in(nr,nc) && m[nr][nc]=='.'){
                                    q.add(nr);
                                    q.add(nc);
                                }
                            }
                        }
                        if(!reach){
                            for(int[] ar : cord){
                                m[ar[0]][ar[1]] = '#';
                            }
                        }
                    }
                }
            }
            long total = 0;
            for(int[] ar : al){
                int r = ar[0], c = ar[1];
                for (int i = 0; i < 4; i++) {
                    int nr = r + vr[i];
                    int nc = c + vc[i];
                    if (in(nr, nc)&& m[nr][nc] == '#') {
                        count[r][c]--;
                    }
                }
            }
            for(int[] ar : al){
                total+=count[ar[0]][ar[1]];
            }
            System.out.println(total);
        }
    }
    public void recur(int r, int c){
        if(in(r,c) && m[r][c]=='.'){
            cord.add(new int[]{r,c});
            m[r][c]='@';
            if(r==0||c==0||r==m.length-1||c==m[r].length-1){
                reach = true;
                return;
            }
            recur(r-1,c);
            recur(r+1,c);
            recur(r,c-1);
            recur(r,c+1);
        }
    }
    public boolean in(int r, int c){
        return r >=0 && c>=0&&r<m.length&&c<m[r].length;
    }
    public static void main(String[] args) throws FileNotFoundException{
        new erbatur().run();
    }
}