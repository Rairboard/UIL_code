import java.util.*;
import java.io.*;

public class baseball {
    public static void main(String[] args) throws Exception {
        new baseball().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("baseball.dat"));
        //Scanner f = new Scanner(System.in);
		while(f.hasNext()){
			f.next();
			double totalHit = 0, totalAt = 0, bestHit = 0, bestAt = 0;
			for (int i = 1; i <= 10; i++) {
				totalHit +=f.nextInt();
				totalAt += f.nextInt();
				if(totalHit/totalAt >= bestHit){
					bestHit = totalHit/totalAt;
					bestAt = i;
				}
			}
			f.next();
			String n = String.format("%.3f", bestHit);
			if(bestHit < 1){
				System.out.println("BATTING " + n.substring(n.indexOf(".")) + " FOR THE LAST " + ((int)bestAt)  + " GAME(S)");
			}
			else{
				System.out.printf("BATTING %.3f FOR THE LAST %s GAME(S)%n", bestHit, (int)bestAt);
			}
		}
        f.close();
    }
}
