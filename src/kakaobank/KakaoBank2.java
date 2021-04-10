package kakaobank;

import java.util.*;

public class KakaoBank2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"DEPOSIT 3a 10000", "CREATE 3a 300000", "WITHDRAW 3a 150000", "WITHDRAW 3a 150001"})));
        // result [404, 200, 200, 403]
        System.out.println(Arrays.toString(solution(new String[]{"CREATE 3a 10000", "CREATE 3a 20000", "CREATE 2bw 30000"})));
    }

    public static int[] solution(String[] reqs) {
        int[] answer = new int[reqs.length];

        Map<String, Integer> account = new HashMap<>();

        for(int i=0; i<reqs.length; i++) {
            String[] req = reqs[i].split(" ");
            Integer amount = account.get(req[1]);

            if("CREATE".equals(req[0])) {
                if(amount != null) {
                    answer[i] = 403;
                    continue;
                }
                account.put(req[1], Integer.valueOf(req[2]));
                answer[i] = 200;
            }
            if("DEPOSIT".equals(req[0])) {
                if(amount == null) {
                    answer[i] = 404;
                    continue;
                }
                Integer plus = amount + Integer.valueOf(req[2]);
                account.put(req[1], plus);
                answer[i] = 200;
            }
            if("WITHDRAW".equals(req[0])) {
                if(amount == null) {
                    answer[i] = 404;
                    continue;
                }
                if(amount - Integer.valueOf(req[2]) < 0) {
                    answer[i] = 403;
                    continue;
                }
                Integer minus = amount - Integer.valueOf(req[2]);
                account.put(req[1], minus);
                answer[i] = 200;
            }
        }

        return answer;
    }
}
