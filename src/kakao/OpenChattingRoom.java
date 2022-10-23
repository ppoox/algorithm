package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChattingRoom {
    public class Solution {
        public String[] solution(String[] records) {
            List<String> list = new ArrayList<>();
            Map<String, String> map = new HashMap<>();

            for(int i=0; i<records.length; i++) {
                String[] str = records[i].split("\\s");
                if("Enter".equals(str[0]) || "Change".equals(str[0])) {
                    map.put(str[1], str[2]);
                }
            }

            for(int i=0; i<records.length; i++) {
                String[] str = records[i].split("\\s");
                if("Enter".equals(str[0])) {
                    String a = map.get(str[1]) + "님이 들어왔습니다.";
                    list.add(a);
                }else if("Leave".equals(str[0])) {
                    String a = map.get(str[1]) + "님이 나갔습니다.";
                    list.add(a);
                }
            }

            return list.toArray(new String[list.size()]);
        }
    }
}
