package programmers;

class Park {

    public int solution(int[] mats, String[][] park) {

        int n = park.length;
        int m = park[0].length;

        int[][] dp = new int[n][m];
        int maxSide = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!park[i][j].equals("-1")) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }

        int answer = -1;
        for(int size:mats)
            if(size <= maxSide)
                answer = Math.max(answer,size);

        return answer;
    }
}