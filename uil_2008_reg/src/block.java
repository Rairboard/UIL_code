import java.util.*;
import java.io.*;
public class block {
    char[][] m;
    int cnt;
    List<int[]> al;
    int ROW,COL;
	public static void main(String[] args)throws Exception {
		new block().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("block.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            ROW = f.nextInt();
            COL = f.nextInt();
            f.nextLine();

            m = new char[ROW][COL];
            for (int i = 0; i < ROW; i++) {
                m[i] = f.nextLine().trim().toCharArray();
            }
            int move = f.nextInt();
            f.nextLine();
            long score = 0;
            for (int i = 0; i < move; i++) {
                int r = f.nextInt()-1;
                int c = f.nextInt()-1;
                if(m[r][c]!='.'){
                    cnt = 0;
                    al = new ArrayList<>();
                    char ch = m[r][c];
                    recur(r,c,m[r][c]);
                    if(cnt<=2){
                        score--;
                        for(int[] ar : al){
                            m[ar[0]][ar[1]] = ch;
                        }
                    }
                    else{
                        score+= (long)Math.pow(cnt, 2);
                        moveBoard(m);
                    }
                }
            }
            System.out.println(score);
            for(char[] cc : m){
                System.out.println(cc);
            }
        }
        f.close();
	}
    public void recur(int r, int c, char ch){
        if(r>=0&&c>=0&&r<ROW&&c<COL&&m[r][c] == ch){
            al.add(new int[]{r,c});
            cnt++;
            m[r][c] = '.';
            recur((r+1)%ROW, c, ch);
            recur(((r-1)+ROW)%ROW, c, ch);
            recur(r,(c+1)%COL, ch);
            recur(r,((c-1)+COL)%COL, ch);
        }
    }
    public void moveBoard(char[][] m){
        for (int i = 0; i < COL; i++) {
            String col = "";
            for (int j = 0; j < ROW; j++) {
                if(m[j][i]!='.'){
                    col+=m[j][i];
                }
            }
            for(int j = ROW-1;j>-1;j--){
                if(col.isEmpty()) {
                    m[j][i] = '.';
                    continue;
                }
                m[j][i] = col.charAt(col.length()-1);
                col = col.substring(0,col.length()-1);
            }
        }
    }
}
