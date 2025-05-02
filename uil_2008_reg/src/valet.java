import java.util.*;
import java.io.*;
public class valet {
	public static void main(String[] args)throws Exception {
		new valet().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("valet.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String[] ln = f.nextLine().trim().split("\\s+");
            String park = ln[0];
            System.out.println(park);
            for(int i = 1;i < ln.length;i++){
                int p = park.indexOf(ln[i]);
                int a = p;
                int b = park.length()-1-p;
                if(a <= b){
                    park = new StringBuilder(park.substring(0,p)).reverse() + park.substring(p+1);
                }
                else{
                    park = park.substring(0,p) + new StringBuilder(park.substring(p+1)).reverse();
                }
                System.out.print(ln[i]+" ");
                if(park.isEmpty()){
                    System.out.println("PARKING LOT EMPTY");
                }
                else System.out.println(park);
            }
            System.out.println();
        }
        f.close();
	}
}
