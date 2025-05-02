import java.util.*;
import java.io.*;
public class bingo {
	public static void main(String[] args)throws Exception {
		new bingo().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("bingo.dat"));
        //Scanner f = new Scanner(System.in);
        String[] one = "5 21 44 51 61 12 17 41 53 69 3 29 0 47 73 2 16 38 60 66 10 18 42 49 63".split(" ");
        String[] two = "11 23 45 60 75 7 16 38 59 71 3 30 0 57 74 12 22 33 58 69 10 17 42 45 70".split(" ");
        String[] three = "1 19 34 55 70 8 22 43 52 72 6 24 0 48 66 9 17 31 56 74 4 28 37 60 67".split(" ");
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>(), c = new ArrayList<>();
        for (int i = 0; i < one.length; i++) {
            a.add(Integer.parseInt(one[i]));
            b.add(Integer.parseInt(two[i]));
            c.add(Integer.parseInt(three[i]));
        }
        int asdf = 1;
        while(f.hasNext()){
            boolean[][] board1 = new boolean[5][5];
            boolean[][] board2 = new boolean[5][5];
            boolean[][] board3 = new boolean[5][5];
            board1[2][2] = board2[2][2] = board3[2][2] = true;
            String result = "No";
            int[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < ar.length; i++) {
                if (c.contains(ar[i])) {
                    int row = c.indexOf(ar[i])/5;
                    int col = c.indexOf(ar[i])%5;
                    board3[row][col] = true;
                    if (win(board3)) {
                        result = "Right";
                        break;
                    }
                }
                if (b.contains(ar[i])) {
                    int row = b.indexOf(ar[i])/5;
                    int col = b.indexOf(ar[i])%5;
                    board2[row][col] = true;
                    if (win(board2)) {
                        result = "Middle";
                        break;
                    }
                }
                if (a.contains(ar[i])) {
                    int row = a.indexOf(ar[i])/5;
                    int col = a.indexOf(ar[i])%5;
                    board1[row][col] = true;
                    if (win(board1)) {
                        result = "Left";
                        break;
                    }
                }
            }
            System.out.println("Game #" + asdf++ + ": " + result + " Bingo");
        }
        f.close();
    }
    public boolean win(boolean[][] board){
        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < 5; i++) {
            if(board[i][i]) diag1++;
            if(board[i][4-i]) diag2++;
        }
        if(diag1==5 || diag2==5) return true;
        for (int i = 0; i < 5; i++) {
            int row = 0, col = 0;
            for (int j = 0; j < 5; j++) {
                if(board[i][j]) row++;
                if(board[j][i]) col++;
            }
            if(row==5 || col==5) return true;
        }
        return false;
    }
}
