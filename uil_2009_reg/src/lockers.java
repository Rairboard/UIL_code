import java.util.*;
import java.io.*;

public class lockers {
    public static void main(String[] args) throws Exception {
        new lockers().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("lockers.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();f.nextLine();
        while (times-- > 0) {
			List<Integer> al = new ArrayList<>();
			Scanner line = new Scanner(f.nextLine());
			line.nextInt();line.nextInt();
			int target = line.nextInt();
			while(line.hasNext()){
				al.add(line.nextInt());
			}
			if(al.get(0) == target){
				System.out.println(al.get(0) + " FOUND ON FIRST TRY");
			}else{
				int d = Math.abs(target-al.get(0));
				for (int i = 1; i < al.size(); i++) {
					if(al.get(i) == target){
						System.out.println(al.get(i) + " FOUND");
						break;
					}
					else if(Math.abs(target-al.get(i)) == d){
						System.out.println(al.get(i) + " SAME");
					}else if(Math.abs(target - al.get(i))  > d){
						System.out.println(al.get(i) + " COLDER");
					}else{
						System.out.println(al.get(i) + " WARMER");
					}
					d = Math.abs(target-al.get(i));
				}
			}
			System.out.println();
        }
        f.close();
    }
}
