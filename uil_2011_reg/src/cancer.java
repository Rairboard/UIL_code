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

public class cancer {
    char[][] m;
    public static void main(String[] args) throws Exception {
        new cancer().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cancer").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            m = new char[n][n];
            char[][] copy;
            for (int i = 0; i < n; i++) {
                m[i] = f.nextLine().trim().toCharArray();
            }
            if (free(m)) {
                out.println(0);
            }
            else{
                int cnt = 0;
                while (cnt++ < 5 && !free(m)) {
                    copy = new char[n][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            int infected = 0;
                            for(int r = i-1;r<= i+1;r++){
                                for(int c = j-1;c<=j+1;c++){
                                    if(r==i&&c==j) continue;
                                    if(r>=0&&c>=0&&r<n&&c<n&&m[r][c]=='#'){
                                        infected++;
                                    }
                                }
                            }
                            if(m[i][j] == '.'){
                                copy[i][j] = infected == 3 ? '#': '.';
                            }
                            else if(m[i][j] == '#'){
                                copy[i][j] = !(infected==2 || infected==3) ? '.' : '#';
                            }
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        m[i] = new String(copy[i]).toCharArray();
//                        out.println(new String(copy[i]));
                    }
//                    out.println();
                }
                out.println(cnt > 5 ? -1 : cnt);
            }
        }
        f.close();
    }
    public boolean free(char[][] m){
        for(char[] c : m){
            if (new String(c).contains("#")) {
                return false;
            }
        }
        return true;
    }
}
