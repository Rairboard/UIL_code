import java.util.*;
import java.io.*;
class bitpacking {
    public static void main(String[] args) throws Exception {
        new bitpacking().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File("bitpacking.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
            long N= f.nextLong();
            String s = Long.toString(N,2);
            while(s.length() < 32){
                s = "0"  +s;
            }
            String a = s.substring(0,9), b = s.substring(9,14), c = s.substring(14,20),d = s.substring(20);
            long  type = Long.parseLong(b,2);
            long subtype = Long.parseLong(c,2);
            long count = Long.parseLong(d,2);
            System.out.print("Type: " + (char)(64 + type)  + " | Sub Type: ");
            if(subtype >=1 && subtype<=61){
                if(subtype>=53){
                    subtype-=52;
                    System.out.print(subtype);
                }
                else if(subtype >= 27){
                    subtype-=26;
                    System.out.print((char)('a'-1+subtype));
                }
                else{
                    System.out.print((char)('A'-1+subtype));
                }
            }
            System.out.println(" | Inventory: " + count);
        }
        f.close();
    }
}
