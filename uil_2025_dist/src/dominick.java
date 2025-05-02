//import java.util.*;
//import java.io.*;
//public class dominick {
//    Map<Integer,Integer> index;
//	public static void main(String[] args)throws Exception {
//		new dominick().run();
//	}
//	public void run() throws Exception{
//        Scanner f = new Scanner(new File("dominick.dat"));
//        //Scanner f = new Scanner(System.in);
//        int times = f.nextInt();
//        f.nextLine();
//        for(int asdf = 1;asdf <= times;asdf++){
//            index = new HashMap<>();
//            Stack<Integer>[] s = new Stack[3];
//            for (int i = 0; i < 3; i++) {
//                s[i] = new Stack<>();
//            }
//            int[] size = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//            for (int i = 0; i < size.length; i++) {
//                s[0].push(size[i]);
//                index.put(size[i], 0);
//            }
//            recur(s, -1, )
//        }
//        f.close();
//	}
//}
