import java.util.*;
import java.io.*;
public class endless {
	public static void main(String[] args)throws Exception {
		new endless().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("endless.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        out: for(int asdf = 1;asdf <= times;asdf++){
            char[][] m = new char[3][3];
            for (int i = 0; i < 3; i++) {
                Arrays.fill(m[i], ' ');
            }
            int move = f.nextInt();
            char sign = 'X';
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < move; i++) {
                int r = f.nextInt()-1, c = f.nextInt()-1;
                if(m[r][c]==' '){
                    m[r][c] = sign;
                    sign = sign=='X'?'O':'X';
                    q.offer(new int[]{r,c});
                }
                char winner = win(m);
                if(winner!='?'){
                    System.out.println("Player using '" + winner + "' wins");
                    continue out;
                }
                if(q.size()>=7) {
                    int[] remove = q.remove();
                    m[remove[0]][remove[1]] = ' ';
                }
            }
            System.out.println("Neither player has won yet...");
        }
        f.close();
	}
    public char win(char[][] m){
        String diag1 = "", diag2 = "";
        for (int i = 0; i < 3; i++) {
            diag1+=m[i][i];
            diag2+=m[i][2-i];
        }
        if(diag1.equals("XXX") || diag2.equals("XXX")) return 'X';
        if(diag1.equals("OOO") || diag2.equals("OOO")) return 'O';
        for (int i = 0; i < 3; i++) {
            String row = "", col = "";
            for (int j = 0; j < 3; j++) {
                row+=m[i][j];
                col+=m[j][i];
            }
            if(row.equals("XXX") || col.equals("XXX")) return 'X';
            if(row.equals("OOO") || col.equals("OOO")) return 'O';
        }
        return '?';
    }
}
