import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.*;
import java.io.*;
public class room{
	int[] vr = {-1,-1,-1,1,1,1,0,0};
	int[] vc = {-1,1,0,1,-1,0,-1,1};
  char[][] m;
  int area;
	public static void main(String[] args)throws Exception{
	  new room().run();
	}
	public void run()throws Exception{
	  Scanner f = new Scanner(new File("room.dat"));
	  int N=f.nextInt();
	  while(N-->0){
		  int r = f.nextInt(), c = f.nextInt(), sr = -1, sc = -1;
		  f.nextLine();
		  m = new char[r][c];
		  area = 0;
		  for (int i = 0; i < r; i++) {
			  String ln = f.nextLine();
			  m[i] = ln.toCharArray();
			  if(ln.contains("@")){
				  sr = i;
				  sc = ln.indexOf("@");
			  }
		  }
		  Queue<Integer> q = new LinkedList<>();
		  q.offer(sr);
		  q.offer(sc);
		  while (!q.isEmpty()) {
			  int rr = q.remove(), cc = q.remove();
			  if(rr>=0&&rr<m.length&&cc>=0&&cc<m[rr].length&&m[rr][cc]!='#'){
				  area++;
				  for (int i = 0; i < 8; i++) {
					  q.offer(rr + vr[i]);
					  q.offer(cc + vc[i]);
				  }
				  m[rr][cc] = '#';
			  }
		  }
		  System.out.println("$" + area);
	  }
	}
}
