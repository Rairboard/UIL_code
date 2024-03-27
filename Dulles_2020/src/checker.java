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
public class checker{
	static int line=1;
	static boolean wrong = false, error = false;
	public static void main(String[] args)throws Exception {
		Scanner judge = new Scanner(new File("point_collection.out"));
		Scanner contestant = new Scanner(new File("stu.out"));
		while(judge.hasNext()) {
			String judgeOutput = judge.nextLine().trim(), contestantOutput = contestant.nextLine().trim();
			try {
				if(!judgeOutput.equals(contestantOutput)) {
					wrong = true;
					System.out.println("Line " + line + " is wrong");
					System.out.println("Judge output : " + judgeOutput + "\nYour output : " + contestantOutput);
				}
			}
			catch(Exception e) {
				error = true;
				out.println("Line " + line + " throws " + e);
			}
			line++;
		}
		System.out.println(error ? "Run time - Error" : wrong ? "No - Wrong Answer" : "Yes");
	}
}
