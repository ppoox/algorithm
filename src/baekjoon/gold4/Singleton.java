package baekjoon.gold4;

import java.math.BigDecimal;
import java.util.List;

public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    static class Item {
        private String label;
        private BigDecimal price;

        public Item(String label, BigDecimal price) {
            this.label = label;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        String jsonStr = "{\n" +
                "       \"items\": [\n" +
                "         {\n" +
                "           \"label\": \"캐시미어 100% 터틀넥 스웨터\",\n" +
                "           \"price\": 70000\n" +
                "         },\n" +
                "         {\n" +
                "           \"label\": \"반팔 스트라이프 스웨터\",\n" +
                "           \"price\": 30000\n" +
                "         },\n" +
                "         {\n" +
                "           \"label\": \"화이트 스포츠 점퍼\",\n" +
                "           \"price\": 150000\n" +
                "         }\n" +
                "       ]\n" +
                "   }";




        List<Item> items = List.of(
                new Item("캐시미어 100% 터틀넥 스웨터", new BigDecimal(70000)),
                new Item("반팔 스트라이프 스웨터", new BigDecimal(30000)),
                new Item("화이트 스포츠 점퍼", new BigDecimal(150000))
        );


    }
}
