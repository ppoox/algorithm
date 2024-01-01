package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No1966 {
    public static class Document {
        private int index;
        private int weight;

        public Document(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        public int getIndex() {
            return index;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "index=" + index +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < testCaseCount; i++) {
            int[] printInfo = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = printInfo[0];
            int M = printInfo[1];
            AtomicInteger index = new AtomicInteger(0);
            Queue<Document> documents = Stream.of(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .map(w -> new Document(index.getAndIncrement(), w))
                    .collect(Collectors.toCollection(LinkedList::new));
            results.add(print(M, documents));
        }

        for (Integer r : results) {
            System.out.println(r);
        }
    }

    public static int print(int M, Queue<Document> documents) {
        int count = 0;

        while (!documents.isEmpty()) {
            Document poll = documents.poll();
            boolean isExistMoreThenWeight = false;
            for (Document doc : documents) {
                if (doc.getWeight() > poll.getWeight()) {
                    isExistMoreThenWeight = true;
                    break;
                }
            }
            if (isExistMoreThenWeight) {
                documents.offer(poll);
                continue;
            }
            count++;
            if (poll.getIndex() == M) {
                break;
            }
        }

        return count;
    }
}
