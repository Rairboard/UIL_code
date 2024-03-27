import java.util.*;
import java.io.File;

public class lift {
    public static void main(String[] args) throws Exception {
        new lift().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("lift").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            if(f.nextInt() <= 21200){
                System.out.println("Sammy Klaws can continue to bring joy to the world!");
            }else{
                System.out.println("Steb tried his best, but Sammy Klaws was just too heavy...no more joy to the world.");
            }
        }
        f.close();
    }
}
