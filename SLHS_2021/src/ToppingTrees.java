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

public class ToppingTrees {
    public static void main(String[] args) throws Exception {
        new ToppingTrees().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ToppingTrees").toLowerCase()));
        //Scanner f = new Scanner(System.in);
        int n = f.nextInt(), m = f.nextInt();
		f.nextLine();
		boolean[][] v = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			int a = f.nextInt()-1, b = f.nextInt()-1;
			v[a][b] = true;
			v[b][a] = true;
		}
		List<Integer> trees = new ArrayList<>();
		int[] cnt = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(v[i][j]){
					cnt[i]++;
				}
			}
			max = Math.max(max,cnt[i]);
		}
		for (int i = 0; i < n; i++) {
			if(cnt[i]==max){
				trees.add(i+1);
			}
		}
		Collections.sort(trees);
		out.println(trees.get(0));
        f.close();
    }
}
