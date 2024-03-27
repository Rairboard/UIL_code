import java.util.*;
import java.io.*;
public class isaac {
	int max_column_length = 60;
	public static void main(String[] args)throws Exception {
		new isaac().run();
	}
	public void run() throws Exception{
	  Scanner f = new Scanner(new File("isaac.dat"));
	  //Scanner f = new Scanner(System.in);
	  int times = f.nextInt();
		for (int t = 1; t <= times; t++) {
			int cases = f.nextInt();
			f.nextLine();
			Set<String> s = new TreeSet<>();
			int row = 0, col = 0, max_len = 0;
			while(cases-->0){
				String a= f.next();
				max_len = Math.max(max_len, a.length());
				s.add(a);
			}
			outer : for (int r = 1; r <= Integer.MAX_VALUE; r++) {
				for (int c = 1; c <= (max_len == max_column_length ? 60/max_len : (60-max_len)/(max_len+2) + 1); c++) {
					if(s.size() <= r * c){
						row = r;
						col = c;
						break outer;
					}
				}
			}
			List<String> al =new ArrayList<>(s);
			String[][] m = new String[row][col];
			for (int c = 0; c < col; c++) {
				for (int r = 0; r < row; r++) {
					if(!al.isEmpty()){
						String pattern;
						if(c == col-1){
							pattern = "%-" + max_len + "s";
						} else{
							pattern = "%-" + (max_len+2) + "s";
						}
						m[r][c] = String.format(pattern, al.remove(0));
					}
				}
			}
			System.out.println("Case " + t);
			System.out.println("         111111111122222222223333333333444444444455555555556\n"+"123456789012345678901234567890123456789012345678901234567890\n"+"------------------------------------------------------------");
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if(m[r][c] != null){
						System.out.print(m[r][c]);
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	  f.close();
	}
}
