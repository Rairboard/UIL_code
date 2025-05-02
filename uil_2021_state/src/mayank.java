import java.util.*;
import java.io.*;
public class mayank {
	public static void main(String[] args)throws Exception {
		new mayank().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("mayank.dat"));
        //Scanner f = new Scanner(System.in);
        String alp = "ABCDEFGHJKLMNPRSTUVWXYZ";
        int[] value = {1,2,3,4,5,6,7,8,1,2,3,4,5,7,9,2,3,4,5,6,7,8,9};
        int[] weight ={8,7,6,5,4,3,2,10,0,9,8,7,6,5,4,3,2};
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String ln = f.nextLine().trim();
            char check1 = ln.charAt(8);
            long sum = 0;
            for (int i = 0; i < ln.length(); i++) {
                if(ln.substring(i,i+1).matches("[0-9]")){
                    sum += (ln.charAt(i) - '0') * weight[i];
                }
                else{
                    sum += value[alp.indexOf(ln.charAt(i))] * weight[i];
                }
            }
            long remainder = sum % 11;
            char check2 = (char)('0' + remainder);
            if(remainder == 10) check2 = 'X';
            System.out.printf("#%d: ", asdf);
            if(check1 == check2){
                System.out.println("VALID");
            }
            else System.out.println("INVALID " + check2);
        }
        f.close();
	}
}
