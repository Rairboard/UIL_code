import java.util.*;
import java.io.*;
class target{
	public static void main(String[] args)throws Exception{
		new target().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("target.dat"));
	   int m = f.nextInt(),n = f.nextInt();
	   Map<String,List<Point>> officer = new HashMap<>();
	   while(m-->0){
	      String name = f.next();
	      officer.put(name,new ArrayList<>());
	      for(int i=0;i<5;i++){
	          officer.get(name).add(new Point(f.next()));
	      }
	   }
	   for(int t=1;t<=n;t++){
	       Point tgt = new Point(f.next());
	       Map<Double,String> score = new TreeMap<>();
	       for(String person : officer.keySet()){
	           List<Double> al = new ArrayList<>();
	           for(Point p : officer.get(person)){
	               double d = Math.sqrt(Math.pow(p.x - tgt.x,2) + Math.pow(p.y - tgt.y,2));
	               al.add(d);
	           }
	           Collections.sort(al);
	           double sum = al.get(0) + al.get(1) + al.get(2);
	           score.put(sum,person);
	       }
	       String winner = new ArrayList<>(score.values()).get(0);
	       double best = new ArrayList<>(score.keySet()).get(0);
	       System.out.println("TARGET " + t + " " + winner + " " + Math.round(best));
	   }
	}
	class Point{
	    int x,y;
	    public Point(String s){
	        String[] a = s.split(",");
	        this.x = Integer.parseInt(a[0].substring(a[0].indexOf("(")+1));
	        this.y = Integer.parseInt(a[1].substring(0,a[1].indexOf(")")));
	    }
	}
}
