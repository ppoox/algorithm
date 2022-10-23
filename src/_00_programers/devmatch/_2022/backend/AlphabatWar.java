package _00_programers.devmatch._2022.backend;

import java.util.Arrays;

public class AlphabatWar {
    public static void main(String[] args) {
        String[] maps = {"AABCA.QA", "AABC..QX", "BBBC.Y..", ".A...T.A", "....EE..", ".M.XXEXQ", "KL.TBBBQ"};
        new AlphabatWar().solution(maps);
    }

    static int[] countries = new int[26];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public int solution(String[] maps) {
        char[][] territories = new char[maps.length][maps[0].length()];
        for (int i = 0; i < territories.length; i++) {
            territories[i] = maps[i].toCharArray();
        }
        int[] result = new int[26];

        for (int i = 0; i < territories.length; i++) {
            for (int j = 0; j < territories[0].length; j++) {
                DFS(territories, j, i);

                int maxCountryIndex = 0;
                int maxTerritory = countries[0];
                for (int k = 1; k < countries.length; k++) {
                    int territory = countries[k];
                    if (maxTerritory <= territory) {
                        maxCountryIndex = k;
                        maxTerritory = territory;
                    }
                }
                int sum = 0;
                for (int k = 0; k < countries.length; k++) {
                    int territory = countries[k];
                    if (maxTerritory == territory) {
                        result[k] += territory;
                    } else {
                        sum += territory;
                    }
                }
                System.out.println(Arrays.toString(countries) + " : " + sum);

                System.out.println();

                result[maxCountryIndex] += sum;
                System.out.println(Arrays.toString(result) + " : " + sum);
                countries = new int[26];
                for (char[] t : territories) {
                    System.out.println(Arrays.toString(t));
                }

            }
        }


        System.out.println(Arrays.toString(result));

        return Arrays.stream(result).max().getAsInt();
    }

    public static void DFS(char[][] territories, int x, int y) {
        int lx = territories[0].length;
        int ly = territories.length;
        if (x < 0 || y < 0 || x >= lx || y >= ly || territories[y][x] == '.') {
            return;
        }

        countries[territories[y][x] - 65] += 1;
        territories[y][x] = '.';
        for (int i = 0; i < 4; i++) {
            DFS(territories, x + dx[i], y + dy[i]);
        }
    }
}
