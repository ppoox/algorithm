package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestOptional {

    public static void main(String[] args) {
        test();
    }

    public static void test() {

//        Optional<List<Test>> tList = Optional.ofNullable(getNullList());

        List<Test> testList = new ArrayList<>();
        Test t1 = new Test();
        t1.setNo("1");
        t1.setName("콜린");
        Test t2 = new Test();
        t2.setNo("2");
        t2.setName("윌리엄");

        testList.add(t1);
        testList.add(null);
        testList.add(t2);

        AtomicBoolean isBreak = new AtomicBoolean(false);
        List<Test> nullList = new ArrayList<>();

        for(Test test : testList) {
            Optional<Test> t = Optional.ofNullable(test);
            isBreak.set(false);
            t.ifPresent(x -> {
                // Not null
            });
//            isBreak.set(true);
//            Test nullTest = new Test();
//            nullTest.setName("추가이름");
//            nullList.add(nullTest);


            if(isBreak.get()) continue;
        }

        nullList.stream().map(x-> x.getName()).forEach(System.out::println);
    }

    public static Test getNull() {
        Test test = new Test();
        test.setName("테스트");
//        return test;
        return null;
    }

    public static List<Test> getNullList() {
        return null;
    }

}
