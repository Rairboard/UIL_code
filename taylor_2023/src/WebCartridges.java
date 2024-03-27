import java.util.*;
import java.io.*;

public class WebCartridges {
    public static void main(String[] args) throws Exception {
        new WebCartridges().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("WebCartridges.in"));
        //Scanner f = new Scanner(System.in);
		int[] ar = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		Map<Integer,Integer> m  = new HashMap<>();
//		int
        f.close();
    }
}
