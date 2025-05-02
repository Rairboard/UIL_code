import java.util.*;
import java.io.*;
public class benjamin {
	public static void main(String[] args)throws Exception {
		new benjamin().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("benjamin.dat"));
        //Scanner f = new Scanner(System.in);
        ArrayList<Long> stack = new ArrayList<>();
        String[] ln = f.nextLine().trim().split("\\s+");
        for (int i = 0; i < ln.length; i++) {
            stack.add(Long.parseLong(ln[i]));
        }
        ArrayList<Long> queue = new ArrayList<>(stack);
        while (f.hasNext()) {
            String[] command = f.nextLine().trim().split("\\s+");
            boolean st = command[0].equals("S");
            for(int i = 1;i < command.length;i++){
                if (command[i].equals("P")) {
                    if(st) stack.removeLast();
                    else queue.removeFirst();
                } else if (command[i].matches("P\\([0-9]+\\)")) {
                    if(st) stack.add(Long.parseLong(command[i].replaceAll("[^0-9]","")));
                    else queue.add(Long.parseLong(command[i].replaceAll("[^0-9]","")));
                } else if (command[i].equals("L")) {
                    long min = Integer.MAX_VALUE;
                    int in = 0;
                    if(st){
                        for (int j = 0; j < stack.size(); j++) {
                            if(stack.get(j) < min){
                                min = stack.get(j);
                                in = j;
                            }
                        }
                        stack.remove(in);
                    }
                    else{
                        for (int j = 0; j < queue.size(); j++) {
                            if(queue.get(j) < min){
                                min = queue.get(j);
                                in = j;
                            }
                        }
                        queue.remove(in);
                    }
                } else if (command[i].matches("L\\([0-9]+\\)")) {
                    long min = Integer.MAX_VALUE;
                    int in = 0;
                    if(st){
                        for (int j = 0; j < stack.size(); j++) {
                            if(stack.get(j) < min){
                                min = stack.get(j);
                                in = j;
                            }
                        }
                        stack.add(in, Long.parseLong(command[i].replaceAll("[^0-9]","")));
                    }
                    else{
                        for (int j = 0; j < queue.size(); j++) {
                            if(queue.get(j) < min){
                                min = queue.get(j);
                                in = j;
                            }
                        }
                            queue.add(in, Long.parseLong(command[i].replaceAll("[^0-9]","")));
                    }

                } else if (command[i].equals("H")) {
                    long min = 0;
                    int in = 0;
                    if(st){
                        for (int j = 0; j < stack.size(); j++) {
                            if(stack.get(j) > min){
                                min = stack.get(j);
                                in = j;
                            }
                        }
                        stack.remove(in);
                    }
                    else{
                        for (int j = 0; j < queue.size(); j++) {
                            if(queue.get(j) > min){
                                min = queue.get(j);
                                in = j;
                            }
                        }
                        queue.remove(in);
                    }
                } else if (command[i].matches("H\\([0-9]+\\)")) {
                    long min = 0;
                    int in = 0;
                    if(st){
                        for (int j = 0; j < stack.size(); j++) {
                            if(stack.get(j) > min){
                                min = stack.get(j);
                                in = j;
                            }
                        }
//                        System.out.println(stack + " " + in  +" " + stack.get(in));
                        stack.add(in+1, Long.parseLong(command[i].replaceAll("[^0-9]","")));
                    }
                    else{
                        for (int j = 0; j < queue.size(); j++) {
                            if(queue.get(j) > min){
                                min = queue.get(j);
                                in = j;
                            }
                        }
//                        System.out.println(queue + " " + in  +" " + queue.get(in));
                        queue.add(in+1, Long.parseLong(command[i].replaceAll("[^0-9]","")));
                    }
                } else if (command[i].equals("M")) {
                    if(st){
                        int mid = stack.size()/2;
                        if(stack.size()%2==0) mid--;
                        stack.remove(mid);
                    }
                    else{
                        int mid = queue.size()/2;
                        if(queue.size()%2==0) mid--;
                        queue.remove(mid);
                    }
                }
                else{
                    if(st){
                        int mid = stack.size()/2;
                        stack.add(mid, Long.parseLong(command[i].replaceAll("[^0-9]","")));
                    }
                    else{
                        int mid = queue.size()/2;
                        queue.add(mid, Long.parseLong(command[i].replaceAll("[^0-9]","")));
                    }
                }
            }
            System.out.println(command[0] + " " + (st ? stack : queue));
        }
        f.close();
	}
}
