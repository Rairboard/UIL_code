import java.util.*;
import java.io.File;

public class tomek {
    char[][] m;
    boolean border;
    int cnt;
    public static void main(String[] args) throws Exception {
        new tomek().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("tomek").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            m = new char[row][col];
            List<Integer> al = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().trim().toCharArray();
            }
            for(int i = 1; i < row-1;i++){
                for(int j = 1;j<col-1;j++){
                    if(m[i][j]=='.'){
                        border = false;
                        cnt = 0;
                        recur(i,j);
                        if(!border) al.add(cnt);
                    }
                }
            }
            Collections.sort(al);
            System.out.println("Case #" + asdf + ": " + al.size());
            if(al.isEmpty()) System.out.println("NONE");
            else{
                for(int i = al.size()-1;i>-1;i--){
                    System.out.print(al.get(i)+" ");
                }
                System.out.println();
            }
        }
        f.close();
    }
    public void recur(int r, int c){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='W'){
            if(r==0||c==0||r==m.length-1||c==m[r].length-1) {
                border = true;
                return;
            }
            m[r][c] = 'W';
            cnt++;
            recur(r-1,c);
            recur(r+1,c);
            recur(r,c-1);
            recur(r,c+1);
        }
    }
}
