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
        while (times-- > 0) {
			String l = f.nextLine();
			String[] e = l.split("\\s+");
			if(l.contains("/")) {
				if(e.length == 5) {
					String[] fraction = l.split("\\s*and\\s*");
					String[] one = fraction[0].split("\\s+|/"), two = fraction[1].split("\\s+|/");
					long w1 = Long.parseLong(one[0]), n1 = Long.parseLong(one[1]), d1 = Long.parseLong(one[2]);
					long w2 = Long.parseLong(two[0]), n2 = Long.parseLong(two[1]), d2 = Long.parseLong(two[2]);
					F f1 = new F(w1 * d1 + n1, d1);
					F f2 = new F(w2 * d2 + n2, d2);
					F res = f1.add(f2);
					System.out.println(res.toMixedFraction());
				} else {
					String[] fraction = l.split("\\s*and\\s*");
					String[] one = fraction[0].split("/"), two = fraction[1].split("/");
					F f1 = new F(Long.parseLong(one[0]), Long.parseLong(one[1]));
					F f2 = new F(Long.parseLong(two[0]), Long.parseLong(two[1]));
					F res = f1.add(f2);
					System.out.println(res);
				}
			} else{
				System.out.println(Long.parseLong(e[0]) + Long.parseLong(e[2]));
			}
        }
        f.close();
    }
	public long gcf(long a, long b){
		if(b==0){
			return a;
		}
		return gcf(b, a%b);
	}
	class F{
		public long numerator;
		public long denominator;
		public F(long a, long b){
			this.numerator = a;
			this.denominator =b;
			simplifyFraction();
		}
		public F add(F other) {
			long lcm = Math.abs(denominator * other.denominator) / gcf(denominator, other.denominator);
			long num1 = numerator * (lcm / denominator);
			long num2 = other.numerator * (lcm / other.denominator);

			long resultNum = num1 + num2;
			long resultDenom = lcm;

			return new F(resultNum, resultDenom);
		}
		public String toString(){
			if(denominator == 1){
				return Long.toString(this.numerator);
			}
			return this.numerator + "/" + this.denominator;
		}
		public String toMixedFraction(){
			long whole = this.numerator/this.denominator;
			return whole + " " + (this.numerator%this.denominator) + "/" + this.denominator;
		}
		public void simplifyFraction() {
			if (denominator == 0) {
				throw new IllegalArgumentException("Denominator cannot be zero.");
			}
			if (numerator == 0) {
				denominator = 1;
				return;
			}

			int sign = 1;
			if (numerator < 0) {
				sign = -sign;
				numerator = -numerator;
			}
			if (denominator < 0) {
				sign = -sign;
				denominator = -denominator;
			}

			long divisor = gcf(numerator, denominator);
			numerator /= divisor;
			denominator /= divisor;
			numerator *= sign;
		}
	}
}
