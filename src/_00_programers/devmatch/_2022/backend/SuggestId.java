package _00_programers.devmatch._2022.backend;

import java.util.Arrays;

public class SuggestId {
    private static final String REGEXP_ONLY_STRING = "[0-9]";
    private static final String REGEXP_ONLY_NUMBER = "[^0-9]";

    public static void main(String[] args) {
        String[] registers =
                {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
        String[] registers2 =
                {"bird99", "bird98", "bird101", "gotoxy"};
        System.out.println(new SuggestId().solution(registers, "cow"));
        System.out.println(new SuggestId().solution(registers2, "bird98"));
    }
    public String solution(String[] registered_list, String new_id) {
        String answer = "";
        int len = registered_list.length;
        /**
         * 존재하지 않으면 그대로 추천
         */
        boolean isDuplicate = false;
        for (int i = 0; i < len; i++) {
            if (new_id.equals(registered_list[i])) {
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            return new_id;
        }

        Arrays.sort(registered_list);

        /**
         * 존재하는 경우 S + (N+1)
         * 단, N이 없는 경우는 null로 가정
         */
        String S = new_id.replaceAll(REGEXP_ONLY_STRING, "");
        String N = new_id.replaceAll(REGEXP_ONLY_NUMBER, "");
        int nextN = "".equals(N) ? 0 : Integer.parseInt(N);
        for (int i = 0; i < len; i++) {
            if (registered_list[i].startsWith(S)) {
                String rns = registered_list[i].replaceAll(REGEXP_ONLY_NUMBER, "");
                int rn = "".equals(rns) ? 0 : Integer.parseInt(rns);
                if (rn == nextN) {
                    nextN++;
                }
            }
        }

        return S + nextN;
    }
}
