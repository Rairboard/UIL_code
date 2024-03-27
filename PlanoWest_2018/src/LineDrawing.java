import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class LineDrawing {
    public static void main(String[] args) throws Exception {
        new LineDrawing().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("LineDrawing").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			int r = f.nextInt(), c = f.nextInt(), n = f.nextInt();
			f.nextLine();
			int[][] m = new int[r][c];
			boolean found = false;
			for (int i = 0; i < r; i++) {
				m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			}
			HashSet<Integer> hs = new HashSet<>();
			for (int i = 0; i < r; i++) {
				int row = 0;
				for (int j = 0; j < c; j++) {
					row+=m[i][j];
					hs.add(row);
				}
			}
			for(int i = 0;i < c;i++){
				int col = 0;
				for(int j = 0; j < r;j++){
					col+=m[j][i];
					hs.add(col);
				}
			}
			for (int i = 0; i < n; i++) {
				if (hs.contains(f.nextInt())) {
					out.println("YES");
				}
				else{
					out.println("NO");
				}
			}
		}
        f.close();
    }
}
