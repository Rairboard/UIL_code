import java.util.*;
import java.io.File;

public class Ingredients_ThanhLe {
    public static void main(String[] args) throws Exception {
        new Ingredients_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("ingredients.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int n = f.nextInt(),c=f.nextInt();f.nextLine();
            List<String> el = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
            List<String> needed = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
//            if(!needed.contains("1")){
//                needed.add("1");
//            }
            needed.removeIf(e -> el.contains(e));
            if(!el.contains("1")){
                if(needed.size() == 0){
                    System.out.println("I guess it's time to have a normal brownie...");
                }else {
                    System.out.println(":(");
                }
            }else{
                if(needed.size()==0){
                    System.out.println("Time to take a trip to stratosphere!");
                }else{
                    System.out.println(":(");
                }
            }
        }
        f.close();
    }
}
