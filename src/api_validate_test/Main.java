package api_validate_test;

import com.sun.istack.internal.Nullable;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Integer resultCode = null;
        String[] strs = null;
        ApiModel model = new ApiModel();

        // obj 널체크
        if (isObjectBlank(model)) {
            resultCode = 101;
            strs = new String[]{"모델이 널입니다."};
        }else {
            // 파라미터 널체크
            if (isTextBlank(model.getNo())) {
                resultCode = 102;
                strs = new String[]{"No가 널입니다."};
            } else if (isTextBlank(model.getValue())) {
                resultCode = 102;
                strs = new String[]{"Value가 널입니다."};
            } else {
                // 파라미터 사이즈체크
                if (model.getNo().length() > 3) {
                    resultCode = 103;
                    strs = new String[]{"No의 길이가 큽니다."};
                } else if (model.getValue().length() > 5) {
                    resultCode = 103;
                    strs = new String[]{"Value의 길이가 큽니다."};
                } else {
                    // 통과
                    resultCode = 0;
                    strs = new String[]{"정상처리"};
                }
            }
        }

        System.out.println("결과코드 : " + resultCode);
        message(null);

    }

    private static void message(Integer aa) {
        if(aa == null) {
            aa = 99999;
        }
        switch (aa) {
            case 0:
                System.out.println("정상처리");
                break;
            case 101:
                System.out.println("모델이 널입니다.");
                break;
            case 102:
                System.out.println("파라미터가 널입니다.");
                break;
            default:
            System.out.println("디폴트 메세지 입니다.");
                break;
        }
    }

    private static boolean isTextBlank(String str) {
        return str == null || str.isEmpty() ? true : false;
    }

    private static boolean isObjectBlank(Object obj) {
        if (obj instanceof String) return obj == null || "".equals(obj.toString().trim());
        else if (obj instanceof List) return obj == null || ((List) obj).isEmpty();
        else if (obj instanceof Map) return obj == null || ((Map<Object, Object>) obj).isEmpty();
        else if (obj instanceof Object[]) return obj == null || Array.getLength(obj) == 0;
        else return obj == null;
    }
}