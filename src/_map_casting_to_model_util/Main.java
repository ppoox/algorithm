package _map_casting_to_model_util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
//        Map<String, Object> map = new HashMap<>();
//        map.put("no", "2");
//        map.put("name", "맛동산");
//        map.put("addr", "홍콩");
//        TestModel tm = new TestModel();
//        Method[] methods = tm.getClass().getDeclaredMethods();
//        for(String key : map.keySet()) {
//
//            String methodString = "set"+key.substring(0,1).toUpperCase()+key.substring(1);
//            int count = 0;
//            for(Method m : methods) {
//                System.out.println(methods[count]);
//                if(methodString.equals(methods[count].getName())) {
//                    methods[count].invoke(tm, map.get(key));
//                }
//                count++;
//            }
//        }
//        System.out.println(tm.getNo() + " | " + tm.getName() + " | " + tm.getAddr());

        parameterMapUtil(TestModel.class);
    }

    public static Class<?> parameterMapUtil(Class<?> clazz) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("no", "2");
        map.put("name", "맛동산");
        map.put("addr", "홍콩");

        TestModel tm2 = new TestModel();

        Method[] methods = tm2.getClass().getDeclaredMethods();
        for(String key : map.keySet()) {

            String methodString = "set"+key.substring(0,1).toUpperCase()+key.substring(1);
            int count = 0;
            for(Method m : methods) {
                //System.out.println(methods[count]);
                if(methodString.equals(methods[count].getName())) {
                    methods[count].invoke(tm2, map.get(key));
                }
                count++;
            }
        }

        System.out.println(tm2.getNo() + " | " + tm2.getName() + " | " + tm2.getAddr());

        return clazz.getClass();
    }
}
