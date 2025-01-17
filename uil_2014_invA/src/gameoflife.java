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

public class gameoflife {
    public static void main(String[] args) throws Exception {
        new gameoflife().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("gameoflife").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt(), gen = f.nextInt();
			if(f.hasNext()) f.nextLine();
			char[][] m = new char[n][n];
			for (int i = 0; i < n; i++) {
				m[i] = f.nextLine().trim().toCharArray();
			}
			int[] vr = {-1,1,0,0,-1,-1,1,1};
			int[] vc = {0,0,-1,1,-1,1,-1,1};
			for (int k = 0; k < gen; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						int cnt = 0;
						for (int l = 0; l < 8; l++) {
							int r = i + vr[l];
							int c = j + vc[l];
							if(r>=0&&c>=0&&r<n&&c<n&&m[r][c]==m[i][j]){
								cnt++;
							}
						}
						if(m[i][j]=='1'){
							if(cnt>3){
								m[i][j] = '0';
							}
							else if(cnt==3 || cnt == 2){
								m[i][j] = '1';
							}
							else {
								m[i][j] = '0';
							}
						}
						else{
							if(cnt==3){
								m[i][j] = '1';
							}
						}
					}
				}
			}
			for(char[] cc : m){
				out.println(cc);
			}
        }
        f.close();
    }
}
