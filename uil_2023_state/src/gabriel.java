import java.util.*;
import java.io.*;

public class gabriel {
    public static void main(String[] args) throws Exception {
        new gabriel().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("gabriel.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        for (int time = 0; time < times; time++) {
			int N = f.nextInt();
			String[][] m = new String[N][N];
			String s = f.nextLine().replaceAll("\\s+","");
			for (int r = 0; r < m.length; r++) {
				for (int c = 0; c < m[r].length; c++) {
					if(s.length() < N){
						break;
					}
					else{
						m[r][c] = s.substring(0,N);
						try{
							s = s.substring(N);
						}
						catch(Exception e){
							s = "";
						}
					}
				}
			}
			for (int i = 0; i < m.length; i++) {
				boolean flag = false;
				for (int j = 0; j < m[i].length; j++) {
					if(m[i][j]== null){
						flag = true;
						break;
					}
				}
				if(!flag){
					for (int j = 0; j < m[i].length; j++) {
						System.out.print(m[i][j] + " ");
					}
					System.out.println();
				}
				else{
					System.out.println("NOT ENOUGH LETTERS");
					break;
				}
			}
        }
        f.close();
    }
}
