package programmers;

import java.util.Arrays;

public class CodingStudying {
    public int solution(int alp, int cop, int[][] problems) {
        int max_alp = 0, max_cop = 0;
        for (int[] problem : problems) {
            max_alp = Math.max(max_alp, problem[0]);
            max_cop = Math.max(max_cop, problem[1]);
        }

        alp = Math.min(alp, max_alp);
        cop = Math.min(cop, max_cop);

        int[][] dp = new int[max_alp + 1][max_cop + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;
        for (int i = alp; i <= max_alp; i++) {
            for (int j = cop; j <= max_cop; j++) {
                // 알고리즘 공부해서 1 증가하는 경우
                if (i + 1 <= max_alp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                // 코딩 공부해서 1 증가하는 경우
                if (j + 1 <= max_cop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                // 문제 풀기
                for (int[] problem : problems) {
                    int alp_req = problem[0];
                    int cop_req = problem[1];
                    int alp_rwd = problem[2];
                    int cop_rwd = problem[3];
                    int cost = problem[4];

                    if (i >= alp_req && j >= cop_req) { // 현재 능력으로 풀 수 있는 문제
                        int new_alp = Math.min(max_alp, i + alp_rwd);
                        int new_cop = Math.min(max_cop, j + cop_rwd);
                        dp[new_alp][new_cop] = Math.min(dp[new_alp][new_cop], dp[i][j] + cost);
                    }
                }
            }
        }

        return dp[max_alp][max_cop];
    }
}
