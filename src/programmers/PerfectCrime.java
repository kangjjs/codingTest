package programmers;

public class PerfectCrime {
    public int solution(int[][] info, int n, int m) {
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;

        for (int[] item : info) {
            int aAdd = item[0];
            int bAdd = item[1];

            boolean[][] next = new boolean[n][m];
            boolean any = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!dp[i][j])
                        continue;
                    int na = i + aAdd;
                    if (na < n) {
                        next[na][j] = true;
                        any = true;
                    }

                    int nb = j + bAdd;
                    if(nb<m){
                        next[i][nb] = true;
                        any = true;
                    }
                }
            }

            if(!any)
                return -1;
            dp = next;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dp[i][j])
                    return i;
            }
        }

        return -1;
    }
}
