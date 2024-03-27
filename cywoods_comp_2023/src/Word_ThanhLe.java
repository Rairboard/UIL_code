import java.util.*;
import java.io.File;

public class Word_ThanhLe {
    public static void main(String[] args) throws Exception {
        new Word_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Word.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int N = f.nextInt();
            f.nextLine();
            int cnt = 0;
            while(N-->0){
                if(f.nextLine().toLowerCase().contains("christmas")){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
        f.close();
    }
}
