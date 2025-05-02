import java.util.*;
import java.io.*;
public class dara {
	public static void main(String[] args)throws Exception {
		new dara().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("dara.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String[] ln = f.nextLine().split("\\s+");
            String first = deriv(ln[0]);
            for(int i = 2;i< ln.length;i+=2){
                String d = deriv(ln[i]);
                if(d.equals("0")) continue;
                first += " " + ln[i-1] + " " + d;
            }
            ln = first.split("\\s+");
            String second = deriv(ln[0]);
            for(int i = 2;i< ln.length;i+=2){
                String d = deriv(ln[i]);
                if(d.equals("0")) continue;
                second += " " + ln[i-1] + " " + d;
            }
            System.out.println(first + " : " + second);
        }
        f.close();
	}
    public String deriv(String ln){
        if(ln.matches("[0-9]+")) return "0";
        else if (ln.matches("[0-9]*X")) {
            if(ln.equals("X")) return "1";
            return ln.substring(0,ln.indexOf("X"));
        }
        else{
            String[] a = ln.split("X\\^");
            long coeff = 1;
            long pow = Long.parseLong(a[1]);
            if(!a[0].isEmpty()) coeff = Long.parseLong(a[0]);
            if(pow - 1 == 1) return pow * coeff + "X";
            return pow * coeff + "X^" + (pow-1);
        }
    }
}
