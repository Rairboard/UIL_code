import java.util.*;
import java.io.*;
public class wordsearch {
    char[][]m;

	public static void main(String[] args)throws Exception {
		new wordsearch().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("wordsearch.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int row = f.nextInt(), col = f.nextInt(), words = f.nextInt();
            f.nextLine();
            m = new char[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().replaceAll("\\s+","").toCharArray();
            }
            for (int i = 0; i < words; i++) {
                String ln = f.nextLine();
                boolean found = false;
                out: for (int r = 0; r < row; r++) {
                    for (int c = 0; c < col; c++) {
                        if (m[r][c] == ln.charAt(0)) {
                            for(int dr = -1; dr<= 1;dr++){
                                for(int dc = -1;dc<=1;dc++){
                                    if (recur(r, c, 0, ln, dr, dc)) {
                                        System.out.print(1);
                                        found = true;
                                        break out;
                                    }
                                }
                            }
                        }
                    }
                }
                if(!found) System.out.print(0);
            }
            System.out.println();
        }
        f.close();
	}
    public boolean recur(int r, int c, int i, String ln, int dr, int dc){
        r = r % m.length;
        if(r < 0) r+=m.length;
        c = c % m[r].length;
        if(c < 0) c+=m[r].length;
        if(i == ln.length())return true;
        if(m[r][c] != ln.charAt(i)) return false;
        return recur(r+dr, c + dc, i +1, ln, dr,dc);
    }
}
