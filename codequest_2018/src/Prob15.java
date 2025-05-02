import java.util.*;
import java.io.*;
public class Prob15 {
	public static void main(String[] args)throws Exception {
		new Prob15().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob15.in.txt"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String ln = f.nextLine().toUpperCase().trim();
            for (int i = 0; i < ln.length(); i++) {
                int value = ln.charAt(i)-'A'+1;
                if(ln.substring(i,i+1).matches("[A-E]")){
                    value+=6;
                    value%=26;
                    if(value==0) System.out.print(ln.charAt(i));
                    else System.out.print((char)('A' + (value-1)));
                } else if (ln.substring(i, i + 1).matches("[F-J]")) {
                    value*=value;
                    value%=26;
                    if(value==0) System.out.print(ln.charAt(i));
                    else System.out.print((char)('A' + (value-1)));
                } else if (ln.substring(i, i + 1).matches("[K-O]")) {
                    value%=3;
                    value = value * 5 + 1;
                    if(value==0) System.out.print(ln.charAt(i));
                    else System.out.print((char)('A' + (value-1)));
                } else if (ln.substring(i, i + 1).matches("[P-T]")) {
                    int sum = 0;
                    while (value > 0) {
                        sum+=value%10;
                        value/=10;
                    }
                    sum *=8;
                    sum%=26;
                    if(sum==0) System.out.print(ln.charAt(i));
                    else System.out.print((char)('A' + (sum-1)));
                } else if (ln.substring(i, i + 1).matches("[U-Z]")) {
                    for(int j = value-1;j>0;j--){
                        if(value %j==0){
                            value = j;
                            break;
                        }
                    }
                    value*=2;
                    if(value==0) System.out.print(ln.charAt(i));
                    else System.out.print((char)('A' + (value-1)));
                }
            }
            System.out.println();
        }
        f.close();
	}
}
