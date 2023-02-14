package cns;

public class TrackJump {
    public static void main(String[] args) {
        new TrackJump().solution("abc", "bcab");
        new TrackJump().solution("vxrvip", "xrviprvipvxrv");
    }

    public int solution(String reference, String track) {
        int answer = Integer.MAX_VALUE;

        while (track.length() > 0) {
            for (int i = 0; i < reference.length() - 1; i++) {
                String preStr = reference.substring(i);
                if (track.startsWith(preStr)) {
                    int size = preStr.length();
                    track = track.substring(size);
                    answer = Math.min(answer, size);
                }
                String postStr = reference.substring(0, reference.length() - i);
                if (track.startsWith(postStr)) {
                    int size = postStr.length();
                    track = track.substring(size);
                    answer = Math.min(answer, size);
                }
            }
            if (track.length() > 0) {
                for (char c : reference.toCharArray()) {
                    if (c == track.charAt(0)) {
                        track = track.substring(1);
                        answer = 1;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);

        return answer;
    }
}
