import java.nio.file.attribute.UserPrincipalNotFoundException;
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

public class pamela {
    public static void main(String[] args) throws Exception {
        new pamela().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("pamela").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            out.println("Case: " + asdf );
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            int[][] m = new int[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            int[][] rows = new int[2][row];
            int[][] cols = new int[2][col];
            Arrays.fill(rows[1],Integer.MAX_VALUE);
            int min = Integer.MAX_VALUE, max = 0;
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    rows[0][i]+=m[i][j];
                    rows[1][i] = Math.min(rows[1][i],m[i][j]);
                    cols[0][j]+=m[i][j];
                    cols[1][j] = Math.max(cols[1][j],m[i][j]);
                    min = Math.min(min,m[i][j]);
                    max = Math.max(max,m[i][j]);
                }
            }
            out.print("Row Sums:");
            for (int i = 0; i < rows[0].length; i++) {
                out.printf("%7d", rows[0][i]);
            }
            out.print("\nRow Mins:");
            for (int i = 0; i < rows[1].length; i++) {
                out.printf("%7d", rows[1][i]);
            }
            out.print("\nCol Sums:");
            for (int i = 0; i < cols[0].length; i++) {
                out.printf("%7d", cols[0][i]);
            }
            out.print("\nCol Maxs:");
            for (int i = 0; i < cols[1].length; i++) {
                out.printf("%7d",cols[1][i]);
            }
            out.printf("\nMin Mins:%7d\n", min);
            out.printf("Max Maxs:%7d\n",max);
            out.println("=".repeat(20));
        }
        f.close();
    }
}
