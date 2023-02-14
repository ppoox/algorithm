package baekjoon.silver5;

import java.util.*;

class Member implements Comparable<Member> {
    protected int age;
    protected String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member o) {
        return age - o.age;
    }
}

public class No10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Member> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Member(sc.nextInt(), sc.next()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Member m : list) {
            sb.append(m.age)
                    .append(" ")
                    .append(m.name)
                    .append("\n");
        }

        System.out.println(sb);
    }
}
