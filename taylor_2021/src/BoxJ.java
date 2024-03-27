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

public class BoxJ {
    public static void main(String[] args) throws Exception {
        new BoxJ().run();
    }

    public void run() throws Exception {
		char[][] m = new char[4][5];
		for (int i = 0; i < m.length; i++) {
			Arrays.fill(m[i],'*');
		}
		m[2][2] = 'J';
		for(char[] c : m){
			out.println(c);
		}
    }
}
