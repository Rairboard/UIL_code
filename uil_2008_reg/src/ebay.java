import java.util.*;
import java.io.*;
public class ebay {
	public static void main(String[] args)throws Exception {
		new ebay().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("ebay.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            double OLD = 0, NEW = 0;
            double price = f.nextDouble();
            String ln = f.nextLine().trim();
            if (ln.equals("NOT SOLD")) {
                double[] ip = insertion(price);
                OLD += ip[0];
                NEW += ip[1];
            }
            else{
                double[] fp = FINAL(price);
                OLD+= fp[0];
                NEW+=fp[1];
            }
            double net = OLD-NEW;
            if(net==0) System.out.printf("Same $%.2f\n", net);
            else if(net>0) System.out.printf("More $%.2f\n", net);
            else System.out.printf("Less $%.2f\n", -net);
        }
        f.close();
	}
    public double[] FINAL(double p){
        if(p>=1000.01) return new double[]{25 * .0525 + 1000 * .0325 + p * .015, 25 * .0875 + 1000 * .035 + p * .015};
        if(p>=25.01) return new double[]{25 * .0525 + p * .0325 , 25 * .0875 + p * .035 };
        if(p>=0.01) return new double[]{p * .0525, p * .0875};
        return new double[2];
    }
    public double[] insertion(double p){
        if(p>=500) return new double[]{4.8, 4.0};
        if(p>=200) return new double[]{3.6,3.0};
        if(p>=50) return new double[]{2.4, 2};
        if(p>=25) return new double[]{1.2,1};
        if(p>=10) return new double[]{.6,.55};
        if(p>=1) return new double[]{.4, .35};
        return  new double[]{.2, .15};
    }
}
