import java.util.*;
import java.io.*;
public class A {
	public static void main(String[] args)throws Exception {

		new A().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("A.txt"));
        //Scanner f = new Scanner(System.in);
        int game = 1;
        out: while(true){
            Map<String,Long> m = new HashMap<>();
            String winner = "";
            while(true){
                String ln = f.nextLine();
                if(ln.equals("End of games")){
                    break out;
                }
                if (ln.equals("End of game")) {
                    break;
                }
                String[] data = ln.split("\\s+");
                long points = 0;
                data[0] = data[0].substring(0, data[0].length()-1);
                for(int i = 1;i < data.length;i++){
                    points += Long.parseLong(data[i]);
                }
                m.put(data[0], m.getOrDefault(data[0],0L)+points);
                if(m.get(data[0]) >= 301){
                    if(winner.isEmpty()) winner = data[0];
                }
            }
            System.out.print("Game " + game++ + ": ");
            if(winner.isEmpty()){
                System.out.println("Game ended too soon. No one has won.");
            }
            else System.out.println(winner + " has won.");
        }
        f.close();
	}
}
