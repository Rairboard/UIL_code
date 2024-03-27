import java.util.*;
import java.io.File;

public class ChristmasTree_ThanhLe {
    public static void main(String[] args) throws Exception {
        new ChristmasTree_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("ChristmasTree.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int N = f.nextInt();
            f.nextLine();
            List<String> al = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
            List<Character> put = new ArrayList<>();
            char c = al.remove(0).charAt(0);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i * 2; j++) {
                    put.add('-');
                }
            }
            for (int i = 0; i < al.size(); i++) {
                if(!al.get(i).equals("0")){
                    put.set(Integer.parseInt(al.get(i))-1,c);
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = i; j < N - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("/");
                for (int j = 0; j < i * 2; j++) {
                    System.out.print(put.remove(0));
                }
                System.out.println("\\");
            }
            for (int i = 0; i < N-1; i++) {
                System.out.print(" ");
            }
            System.out.println("||");
            System.out.println();
        }
        f.close();
    }
}
