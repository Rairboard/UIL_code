import java.util.*;
import java.io.*;
public class chairs {
	public static void main(String[] args)throws Exception {
		new chairs().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("chairs.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int m = f.nextInt();
            f.nextLine();
            List<String> al = new ArrayList<>(List.of(f.nextLine().split(",\\s+")));
            String[] seat;
            for (int i = 0; i < m; i++) {
//                System.out.println( m-i + " " + al);
                int a = f.nextInt()-1, b = f.nextInt()-1;
                seat = new String[m-i];
                while(a!=b){
                    seat[a] = al.remove(0);
                    a++;
                    if(a==b) break;
                    a%=m-i;
                }
                al.remove(0);
                while(!al.isEmpty()){
                    seat[a] = al.remove(0);
                    a = (a+1) % (m-i);
                }
                al = new ArrayList<>(List.of(seat));
                for(String s : seat){
                    System.out.print(s +" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        f.close();
	}
}
