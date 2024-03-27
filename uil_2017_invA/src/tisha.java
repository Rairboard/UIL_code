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

public class tisha {
    public static void main(String[] args) throws Exception {
        new tisha().run();
    }

    public void run() throws Exception {
		char[][] m = new char[8][8];
		for (int i = 0; i < 8; i++) {
			Arrays.fill(m[i],'-');
		}
		m[0][0] = '\\';
		m[0][1] = '"';
		for(char[] c : m){
			out.println(c);
		}
    }
}
