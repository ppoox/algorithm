package qmit;

public class ReverseStr {
    public static void main(String[] args) {
//        // 문자열 뒤집기 (required)
//        const solution = (word: string) => {
//        // TODO
//                }
//        const answer = solution('qmit-plco')
//                console.log(answer) // oclp-timq

        String solution = new ReverseStr().solution("qmit-plco");
        System.out.println(solution);
    }

    public String solution(String word) {

        char[] chars = word.toCharArray();
        int rt = chars.length - 1;
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[rt];
            chars[rt--] = temp;
        }

        return String.valueOf(chars);
    }
}
