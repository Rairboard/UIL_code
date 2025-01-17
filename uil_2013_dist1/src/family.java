import java.util.*;
import java.io.*;

public class family {
    public static void main(String[] args) throws Exception {
        new family().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("family.dat"));
//        Scanner f = new Scanner(System.in);
        List<Person> al = new ArrayList<>();
        while (f.hasNext()){
            String[] ln = f.nextLine().trim().split("\\s+");
            Person a = new Person(ln[0]);
            Person b = new Person(ln[2]);
            if (ln[1].equals("FATHER") || ln[1].equals("MOTHER")) {
                a.child = b;
            }
            else{
                a.sibling.add(b);
                b.sibling.add(a);
            }
            al.add(a);
        }
        boolean[] visited = new boolean[al.size()];
        for(int i = 0;i < al.size();i++){
          Person  cur = al.get(i);
          boolean connect = false;
          while(cur.child!=null){
              for (int j = 0; j < al.size(); j++) {
                  if (al.get(j).parent.name.equals(cur.child.name)) {
                      visited[j] = true;
                      connect = true;
                      cur.child = al.get(j);
                      break;
                  }
              }
          }
          if(connect) visited[i] = true;
        }
        for(int i = 0;i < al.size();i++){
            Person  cur = al.get(i);
            boolean connect = false;
            while(cur.parent!=null){
                for (int j = 0; j < al.size(); j++) {
                    if (al.get(j).child.name.equals(cur.parent.name)) {
                        visited[j] = true;
                        connect = true;
                        al.get(j).child = cur;
                        break;
                    }
                }
            }
            if(connect) visited[i] = true;
        }

        f.close();
    }
    class Person{
        String name;
        Person parent, child;
        List<Person> sibling;
        public Person(String n){
            sibling = new ArrayList<>();
            name = n;
            parent = child = null;
        }
    }
}
