import javax.swing.*;
import java.util.*;
import java.io.*;

public class diane {
    public static void main(String[] args) throws Exception {
        new diane().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("diane.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
		f.nextLine();
		for (int asdf = 0; asdf < times; asdf++) {
			String[] ln = f.nextLine().trim().split("\\s+and\\s+");
			if (ln[0].contains("/") && ln[1].contains("/")) {
				long[] f1 = erase(ln[0]);
				long[] f2 = erase(ln[1]);
				if(f1[2]==-1) f1[0]*=-1;
				if(f2[2]==-1) f2[0]*=-1;
				long numerator = f1[0] * f2[1] + f1[1] * f2[0];
				long denominator = f1[1] * f2[1];
				long factor = gcf(numerator, denominator);
				if(numerator < 0){
					factor = gcf(Math.abs(numerator), denominator);
				}
				numerator/=factor;
				denominator/=factor;
				if(numerator==0) System.out.println(0);
				else if(Math.abs(numerator)<=denominator){
					System.out.println(numerator+"/"+denominator);
				}
				else{
					long whole = Math.abs(numerator) / denominator;
					long newNum = Math.abs(numerator) % denominator;
					if(numerator<0) whole*=-1;
					System.out.println(whole + " " + newNum + "/" + denominator);
				}
			} else if (ln[0].contains("/") && !ln[1].contains("/")) {
				long[] fraction = erase(ln[0]);
				long number = Long.parseLong(ln[1]);
				if(fraction[2] == -1) fraction[0] *=-1;
				long numerator = number * fraction[1] + fraction[0];
				long denominator = fraction[1];
				long factor = gcf(numerator, denominator);
				if(numerator < 0){
					factor = gcf(Math.abs(numerator), denominator);
				}
				numerator/=factor;
				denominator/=factor;
				if(numerator==0) System.out.println(0);
				else if(Math.abs(numerator)<=denominator){
					System.out.println(numerator+"/"+denominator);
				}
				else{
					long whole = Math.abs(numerator) / denominator;
					long newNum = Math.abs(numerator) % denominator;
					if(numerator<0) whole*=-1;
					System.out.println(whole + " " + newNum + "/" + denominator);
				}
			} else if (!ln[0].contains("/") && ln[1].contains("/")) {
				long[] fraction = erase(ln[1]);
				if(fraction[2]==-1) fraction[0] *= -1;
				long number = Long.parseLong(ln[0]);
				long numerator = number * fraction[1] + fraction[0];
				long denominator = fraction[1];
				long factor = gcf(numerator, denominator);
				if(numerator < 0){
					factor = gcf(Math.abs(numerator), denominator);
				}
				numerator/=factor;
				denominator/=factor;
				if(numerator==0) System.out.println(0);
				else if(Math.abs(numerator)<=denominator){
					System.out.println(numerator+"/"+denominator);
				}
				else{
					long whole = Math.abs(numerator) / denominator;
					long newNum = Math.abs(numerator) % denominator;
					if(numerator<0) whole*=-1;
					System.out.println(whole + " " + newNum + "/" + denominator);
				}
			}
			else{
				System.out.println(Long.parseLong(ln[0]) + Long.parseLong(ln[1]));
			}
        }
        f.close();
    }
	public long gcf(long a,long b){
	    if(a==0){
	        return b;
	    }
	    return gcf(b % a, a);
	}
	public long[] erase(String part){
		String[] ln = part.split("\\s+");
		long[] fraction = new long[3];
		if(ln.length==2){
			String[] a = ln[1].split("/");
			long whole = Long.parseLong(ln[0]);
			long numerator = Long.parseLong(a[0]);
			long denominator = Long.parseLong(a[1]);
			fraction[0] = Math.abs(whole) * denominator + numerator;
			fraction[1] = denominator;
			if(whole<0) fraction[2] = -1;
		}
		else{
			String[] a = ln[0].split("/");
			fraction[0] = Long.parseLong(a[0]);
			fraction[1] = Long.parseLong(a[1]);
			if(fraction[0] < 0) {
				fraction[0] *= -1;
				fraction[2] = -1;
			}
		}
		return fraction;
	}
}
