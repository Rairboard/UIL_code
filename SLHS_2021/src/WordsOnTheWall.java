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

public class WordsOnTheWall {
    public static void main(String[] args) throws Exception {
        new WordsOnTheWall().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("WordsOnTheWall").toLowerCase()));
        //Scanner f = new Scanner(System.in);
        String ln = f.nextLine();
		for (int i = 0; i < ln.length(); i++) {
			out.print(ln.substring(0,ln.length()-i));
		}
        f.close();
    }
}
