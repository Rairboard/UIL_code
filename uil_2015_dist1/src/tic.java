import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class tic {
    public static void main(String[] args) throws Exception {
        new tic().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("tic").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			char[][] m = new char[3][];
			for (int i = 0; i < 3; i++) {
				m[i] = f.nextLine().trim().toCharArray();
			}
			out.println(findWinner(m));
        }
        f.close();
    }
	public String findWinner(char[][] m){
		for (int i = 0; i < 3; i++) {
			String x = "", y = "";
			for (int j = 0; j < 3; j++) {
				x += m[i][j];
				y+=m[j][i];
			}
			if (x.equals("XXX")) return "X WINS";
			if(x.equals("OOO")) return "O WINS";
			if(y.equals("XXX")) return "X WINS";
			if(y.equals("OOO")) return "O WINS";
		}
		String a = "" + m[0][0] + m[1][1] + m[2][2];
		String b = "" + m[0][2] + m[1][1] + m[2][0];
		if(a.equals("XXX")) return "X WINS";
		if(a.equals("OOO")) return "O WINS";
		if(b.equals("XXX")) return "X WINS";
		if(b.equals("OOO")) return "O WINS";
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if(m[i][j]=='.') return "ONGOING";
			}
		}
		return "DRAW";
	}
}
