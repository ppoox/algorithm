package api_validate_test;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ApiModel model = new ApiModel();
        model.setNo("11");
        model.setValue("dd");
//        api(model);

        api(model).forEach((s, o) -> {
            System.out.println("key : " + s + " / value : " + o);
            System.out.println("=======================");
        });

    }

    public static Map<String, Object> api(ApiModel model) {
        Map<String, Object> resultMap;

        // obj 널체크
        if (isObjectBlank(model)) {
            return message(101, "모델");
        }

        // 파라미터 널체크
        if (isTextBlank(model.getNo())) {
            return message(102, "번호");
        } else if (isTextBlank(model.getValue())) {
            return message(102, "값");
        }

        // 파라미터 사이즈체크
        if (model.getNo().length() > 3) {
            return message(103, "번호");
        } else if (model.getValue().length() > 5) {
            return message(103, "값");
        }

        // 통과
        Map<String, Object> map = new HashMap<>();
        map.put("result", "result");
        resultMap = message(0, "");
        resultMap.put("data", "data");

        return resultMap;
    }

    private static Map<String, Object> message(Integer code, String value) {
        Map<String, Object> result = new HashMap<>();
        if(code == null) {
            code = 99999;
        }
        switch (code) {
            case 0:
                result.put("resultMessage", "정상처리");
                break;
            case 101:
                result.put("resultMessage", value + " 모델이 널입니다.");
                break;
            case 102:
                result.put("resultMessage", value + " 파라미터가 널입니다.");
                break;
            case 103:
                result.put("resultMessage", value + " 파라미터 길이가 초과하였습니다.");
                break;
            default:
                result.put("resultMessage", value + " 디폴트 메세지 입니다.");
                break;
        }
        result.put("resultCode", code);

        
        return result;
    }

    private static boolean isTextBlank(String str) {
        return str == null || str.isEmpty();
    }

    private static boolean isObjectBlank(Object obj) {
        if (obj instanceof String) return "".equals(obj.toString().trim());
        else if (obj instanceof List) return ((List) obj).isEmpty();
        else if (obj instanceof Map) return ((Map<Object, Object>) obj).isEmpty();
        else if (obj instanceof Object[]) return Array.getLength(obj) == 0;
        else return obj == null;
    }
}