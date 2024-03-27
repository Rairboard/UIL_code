import java.util.*;
import java.io.*;
class haru {
    static List<Point> spikeLocation;
    public static void main(String[] args) throws Exception{
        new haru().run();
    }
    public void run()throws Exception{
        // Scanner f =new Scanner(System.in);
        Scanner f= new Scanner(new File("haru.dat"));
        int T = f.nextInt();
        while(T-->0){
            int instructions = f.nextInt();
            spikeLocation = new ArrayList<>();
            Point p1 = new Point(f.nextInt(),f.nextInt());String a = f.next();
            Point p2 = new Point(f.nextInt(),f.nextInt());String b =f.next();
            Point tmp1,tmp2;
            spikeLocation.add(p1);spikeLocation.add(p2);
            String res=null;
            for(int i=0;i<instructions;i++){
                tmp1 = new Point(p1.x,p1.y);
                tmp2 = new Point(p2.x,p2.y);
                p1 = movement(a.charAt(i),p1);
                p2 = movement(b.charAt(i),p2);
                if(p1.collide(tmp1,tmp2,p2)){
                    res = "HEAD ON";
                }
                boolean one = inSpikeLocation(p1), two = inSpikeLocation(p2);
                // System.out.println(one + " " + two);
                if(res==null){
                    if(one && two){
                        res = "DOUBLE SPIKE";
                    }
                    else if(one && !two){
                        res = "P2 WIN";
                    }
                    else if(!one && two){
                        res = "P1 WIN";
                    }
                }
                spikeLocation.add(new Point(p1.x,p1.y));
                spikeLocation.add(new Point(p2.x,p2.y));
            }
           if(res==null){
               res = "DRAW";
           }
           System.out.println(res);
        }
    }
    class Point{
        public int x;
        public int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
        public boolean collide(Point o1,Point o2, Point c2){
            if(this.x==c2.x && this.y==c2.y){
                return true;
            }
            if((o1.x==c2.x&&o1.y==c2.y) && (o2.x==this.x&&o2.y==this.y)){
                return true;
            }
            return false;
        }
        public String toString(){
            return "(" + this.x + "," + this.y + ")";
        }
    }
    public Point movement(char c, Point p){
        switch(c){
            case 'U': p = new Point(p.x,p.y+1);break;
            case 'D': p = new Point(p.x,p.y-1);break;
            case 'L': p = new Point(p.x-1,p.y);break;
            case 'R': p = new Point(p.x+1,p.y);break;
        }
        return p;
    }
    public boolean inSpikeLocation(Point p){
        if((p.x < 0 || p.x > 100) || (p.y < 0 || p.y > 100)){
            return true;
        }
        for(Point P : spikeLocation){
            if(P.x == p.x && P.y == p.y){
                return true;
            }
        }
        return false;
    }
}