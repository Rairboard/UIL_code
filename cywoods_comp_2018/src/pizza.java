import java.util.*;
import java.io.File;

public class pizza {
    public static void main(String[] args) throws Exception {
        new pizza().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("pizza").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int i = 1; i<=times;i++){
            String s = f.nextLine();
            System.out.print("TEST " + i + ": ");
            if( s.matches("\\(\\d{3}\\).*(\\d{3}).*([2-9]\\d{3}).*")&&s.replaceAll("[^0-9]","").length()==10){
                if(s.replaceAll("[^0-9]","").equals("8324567890")){
                    System.out.println("GET GRINCHED");
                }else{
                    System.out.println("ORDER AWAY");
                }
            }else{
                System.out.println("INVALID NUMBER");
            }
        }
        f.close();
    }
}
