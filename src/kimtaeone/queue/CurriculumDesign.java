package kimtaeone.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CurriculumDesign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String m = sc.next();

        solution(s, m);
    }

    private static void solution(String s, String m) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }

        for (char c : m.toCharArray()) {
            if (queue.contains(c)) {
                if (c != queue.poll()) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        if (!queue.isEmpty()) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }
}
