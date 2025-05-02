import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class spreadsheetcolumns {
	public static void main(String[] args)throws Exception {
		new spreadsheetcolumns().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("spreadsheetcolumns.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String[] ln = f.nextLine().trim().split("\\s+");
            BigInteger M = new BigInteger(ln[0]);
            BigInteger R = BigInteger.ZERO;
            BigInteger C = BigInteger.ZERO;
            if (ln[1].matches("[0-9]+")) {
                R = new BigInteger(ln[1]);
            }
            else{
                for(int i = ln[1].length()-1;i>=0;i--){
                    R = R.add(BigInteger.valueOf(26).pow(ln[1].length()-1-i).multiply(BigInteger.valueOf(ln[1].charAt(i) - 'A' + 1)));
                }
            }
            if (ln[2].matches("[0-9]+")) {
                C = new BigInteger(ln[2]);
            }
            else{
                for(int i = ln[2].length()-1;i>=0;i--){
                    C = C.add(BigInteger.valueOf(26).pow(ln[2].length()-1-i).multiply(BigInteger.valueOf(ln[2].charAt(i) - 'A' + 1)));
                }
            }
            System.out.println(M.multiply(R).multiply(C));
        }
        f.close();
	}
}
