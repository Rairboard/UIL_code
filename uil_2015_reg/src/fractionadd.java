import java.util.*;
import java.io.*;
public class fractionadd {
	public static void main(String[] args)throws Exception {
		new fractionadd().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("fractionadd.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            List<Long> a = new ArrayList<>(), b = new ArrayList<>();
            long[] left = {0,1};
            long[] right = {0,1};
            String[] ln = f.nextLine().trim().split("\\s+\\?\\s+");
            String[] one = ln[0].split("\\s+\\+\\s+");
            String[] two = ln[1].split("\\s+\\+\\s+");
            for (int i = 0; i < one.length; i++) {
                String[] frac = one[i].split("\\s+/\\s+");
                a.add(Long.parseLong(frac[0]));
                left[1] *= Long.parseLong(frac[1]);
            }
            for (int i = 0; i < two.length; i++) {
                String[] frac = two[i].split("\\s+/\\s+");
                b.add(Long.parseLong(frac[0]));
                right[1] *= Long.parseLong(frac[1]);
            }
            for (int i = 0; i < one.length; i++) {
                String[] frac = one[i].split("\\s+/\\s+");
                left[0] += a.get(i) * (left[1] / Long.parseLong(frac[1]));
            }
            for (int i = 0; i < two.length; i++) {
                String[] frac = two[i].split("\\s+/\\s+");
                right[0] += b.get(i) * (right[1] / Long.parseLong(frac[1]));
            }
            long GCF = gcf(left[0], left[1]);
            left[0] /= GCF;
            left[1] /= GCF;
            GCF = gcf(right[0], right[1]);
            right[0] /= GCF;
            right[1] /= GCF;
            long num1 = left[0] * right[1];
            long num2 = right[0] * left[1];
            System.out.print(left[0] + "/" + left[1]);
            if(num1==num2){
                System.out.print(" = ");
            }
            else if(num1 > num2){
                System.out.print(" > ");
            }
            else System.out.print(" < ");
            System.out.println(right[0] + "/" + right[1]);
        }
        f.close();
	}
    public long gcf(long a, long b){
        if(b==0) return a;
        return gcf(b, a%b);
    }
}
