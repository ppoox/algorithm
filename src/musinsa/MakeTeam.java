package musinsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeTeam {

    public static void main(String[] args) {
        int[] stats1 = {5, 3, 4, 6, 2, 1}; // 4
        int[] stats2 = {6, 2, 3, 4, 1, 5}; // 3
        new MakeTeam().solution(stats1);
        new MakeTeam().solution(stats2);
    }

    public int solution(int[] stats) {
        List<List<Integer>> teamList = new ArrayList<>();

        for (int stat : stats) {
            boolean isAdd = false;
            for (List<Integer> team : teamList) {
                if(team.stream().allMatch(grade -> grade < stat)) {
                    team.add(stat);
                    isAdd = true;
                    break;
                }
            }
            if (!isAdd) {
                List<Integer> newTeam = new ArrayList<>();
                newTeam.add(stat);
                teamList.add(newTeam);
            }
        }

        System.out.println(Arrays.toString(teamList.toArray()));
        return teamList.size();
    }


}
