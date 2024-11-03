import java.util.*;
import java.io.File;

public class bankSort_ThanhLe {
    public static void main(String[] args) throws Exception {
        new bankSort_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bankSort").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                try{
                    sum+=Integer.parseInt(f.nextLine());
                }
                catch(Exception e){}
            }
            if(f.hasNext())f.nextLine();
            System.out.println(sum);
        }
        f.close();
    }
}
