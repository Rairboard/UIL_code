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

public class prob09 {
    public static void main(String[] args) throws Exception {
        new prob09().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("prob09").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
		while(f.hasNext()){
			String a = f.next(), b = f.next();
			if (a.equals(b)) {
				out.println("TIE, " + a + " does not affect " + b);
				continue;
			}
			if (a.equals("Scissors") && b.equals("Paper")) {
				out.println("Scissors WINS, Scissors cuts Paper");
			} else if (a.equals("Paper") && b.equals("Rock")) {
				out.println("Paper WINS, Paper covers Rock");
			} else if(a.equals("Rock")&&b.equals("Lizards")){
				out.println("Rock WINS, Rock crushes Lizard");
			} else if (a.equals("Lizard") && b.equals("Spock")) {
				out.println("Lizard poisons Spock");
			} else if (a.equals("Spock") && b.equals("Scissors")) {
				out.println("Spock smashes Scissors");
			} else if (a.equals("Scissors") && b.equals("Lizard")) {
				out.println("Scissors decapitates Lizard");
			} else if (a.equals("Lizard") && b.equals("Paper")) {
				out.println("Lizard eats Paper");
			} else if (a.equals("Paper") && b.equals("Spock")) {
				out.println("Paper disproves Spock");
			} else if (a.equals("Spock") && b.equals("Rock")) {
				out.println("Spock vaporizes Rock");
			} else if (a.equals("Rock") && b.equals("Scissors")) {
				out.println("Rock crushes Scissors");
			}
		}
        f.close();
    }
}
