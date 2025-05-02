import java.util.*;
import java.io.*;
public class Prob04 {
	public static void main(String[] args)throws Exception {
		new Prob04().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob04.in.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String[] move = f.nextLine().trim().split("\\s+");
            String winner = res(move[0],move[1]);
            if(move.length==2){
                System.out.println(winner);
                continue;
            }
            if (winner.equals("NO WINNER")) {
                winner = move[1];
            }
            for (int i = 2; i < move.length ; i++) {
                winner = res(winner, move[i]);
                if (winner.equals("NO WINNER")) {
                    if(i < move.length-1){
                        winner = move[i];
                    }
                }
            }
            switch (winner){
                case "R" -> System.out.println("ROCK");
                case "P" -> System.out.println("PAPER");
                case "S" -> System.out.println("SCISSORS");
                default -> System.out.println("NO WINNER");
            }
        }
        f.close();
	}
    public String res(String a, String b){
        String res = "NO WINNER";
        if(a.equals("R") ) {
            switch (b){
                case "P" -> res = "P";
                case "S" -> res = "R";
            }
        } else if (a.equals("P")) {
            switch (b){
                case "R" -> res = "P";
                case "S" -> res = "S";
            }
        } else if (a.equals("S")) {
            switch (b){
                case "R" -> res = "R";
                case "P" -> res = "S";
            }
        }
        return res;
    }
}
