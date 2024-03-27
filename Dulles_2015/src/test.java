import java.util.*;
public class test {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            q.add(i);
        }
        System.out.println(q);
    }
}
