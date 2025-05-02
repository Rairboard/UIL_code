import java.util.*;
import java.io.*;
public class bongo {
	public static void main(String[] args)throws Exception {
		new bongo().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("bongo.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            Map<String,int[]> index = new HashMap<>();
            boolean[][] board = new boolean[5][5];
            board[2][2] = true;
            for (int i = 0; i < 5; i++) {
                String[] ln = f.nextLine().trim().split("\\s+");
                for (int j = 0; j < ln.length; j++) {
                    if(i ==2 && j ==2) continue;
                    index.put(ln[j], new int[]{i,j});
                }
            }
            String[] move = f.nextLine().trim().split("\\s+");
            boolean bingo = false;
            for (int i = 0; i < move.length; i++) {
                if (index.containsKey(move[i].substring(1))) {
                    int[] ar = index.get(move[i].substring(1));
                    board[ar[0]][ar[1]] = true;
                    if(win(board)){
                        if(i==move.length-1) bingo = true;
                        else break;
                    }
                }
            }
            if(bingo) System.out.println("BINGO");
            else System.out.println("BONGO");
        }
        f.close();
	}
    public boolean win(boolean[][] board){
        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < 5; i++) {
            if(board[i][i]) diag1++;
            if(board[i][4-i]) diag2++;
        }
        if(diag1==5 || diag2 == 5) return true;
        for (int i = 0; i < 5; i++) {
            int row = 0, col = 0;
            for (int j = 0; j < 5; j++) {
                if(board[i][j]) row++;
                if(board[j][i]) col++;
            }
            if(row==5 || col == 5) return true;
        }
        return false;
    }
}
