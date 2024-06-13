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

public class longhorn {
    public static void main(String[] args) throws Exception {
        new longhorn().run();
    }

    public void run() throws Exception {
		for (int i =1; i <= 12; i++) {
			out.println("|**********************| \n" +
					"|#######........#######| \n" +
					"|....####......####....| \n" +
					"|.......########.......| \n" +
					"|......##########......| \n" +
					"|........######........| \n" +
					"|..........##..........| \n" +
					"|..........##..........| \n" +
					"|..........##..........| \n" +
					"************************");
			out.println(i);
		}

    }
}
