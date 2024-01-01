package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No10825 {
    static class Score implements Comparable<Score> {
        private String name;
        private int korean;
        private int english;
        private int math;

        public Score(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public int getKorean() {
            return korean;
        }

        public int getEnglish() {
            return english;
        }

        public int getMath() {
            return math;
        }

        @Override
        public int compareTo(Score o) {
            if (korean != o.getKorean()) {
                return (korean - o.getKorean()) * -1;
            }
            if (english != o.getEnglish()) {
                return english - o.getEnglish();
            }
            if (math != o.getMath()) {
                return (math - o.getMath()) * -1;
            }
            return name.compareTo(o.getName());
        }
    }

    static int N;
    static Score[] scores;

    public static void main(String[] args) throws IOException {
        input();

        Arrays.stream(scores).sorted().map(Score::getName).forEach(System.out::println);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        scores = new Score[N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] files = line.split(" ");
            scores[i] = new Score(files[0], Integer.parseInt(files[1]), Integer.parseInt(files[2]), Integer.parseInt(files[3]));
        }

        br.close();
    }
}
