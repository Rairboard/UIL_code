import java.util.*;
import java.io.*;
public class Prob17 {
	public static void main(String[] args)throws Exception {
		new Prob17().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob17.in.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String ln = f.nextLine().trim();
            char[][] m = new char[3][3];
            for (int i = 0; i < 3; i++) {
                m[i] = ln.substring(i*3,i * 3+3).toCharArray();
            }
            System.out.println(ln + " = " +  result(m));
        }
        f.close();
	}
    public String result(char[][] m){
        String d1 = "" + m[0][0] + m[1][1] + m[2][2], d2 = "" + m[0][2] + m[1][1] + m[2][0];
        if(d1.equals("XXX") || d2.equals("XXX")) return "X WINS";
        if(d1.equals("OOO") || d2.equals("OOO")) return "O WINS";
        for (int i = 0; i < 3; i++) {
            String row = "", col = "";
            for (int j = 0; j < 3; j++) {
                row+=m[i][j];
                col+=m[j][i];
            }
            if(row.equals("XXX") || col.equals("XXX")) return "X WINS";
            if(row.equals("OOO") || col.equals("OOO")) return "O WINS";
        }
        return "TIE";
    }
}
