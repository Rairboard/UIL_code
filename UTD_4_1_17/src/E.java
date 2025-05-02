import java.util.*;
import java.io.*;
public class E {
	public static void main(String[] args)throws Exception {
		new E().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("E.txt"));
        //Scanner f = new Scanner(System.in);
        int asdf = 1;
        while (f.hasNext()) {
            boolean valid = true;
            String alp = f.nextLine();
            HashSet<Character> goal = new HashSet<>();
            for (int i = 0; i < alp.length(); i++) {
                goal.add(alp.charAt(i));
            }
            char[][] m = new char[9][9];
            for (int i = 0; i < 9; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            if(f.hasNext())f.nextLine();
            for(int i = 0;i < 9;i++){
                HashSet<Character> row = new HashSet<>(), col = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    row.add(m[i][j]);
                    col.add(m[j][i]);
                }
                if (!row.equals(goal) || !col.equals(goal)) {
                    valid = false;
                    break;
                }
            }
            out : for(int i = 0;i < 9;i+=3){
                for(int j = 0;j < 9;j+=3){
                    HashSet<Character> block = new HashSet<>();
                    for(int r = i;r<i+3;r++){
                        for(int c = j;c < j + 3;c++){
                            block.add(m[r][c]);
                        }
                    }
                    if (block.size() != 9 || !block.equals(goal)) {
                        valid = false;
                        break out;
                    }
                }
            }
            System.out.print("Grid " +asdf++ + ": This is ");
            if(!valid) System.out.print("not ");
            System.out.println("a valid Sudoku solution.");
        }
        f.close();
	}
}
