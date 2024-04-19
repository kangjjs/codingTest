package programmers;

class Ranking {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];

        for (int[] x : results) {
            graph[x[0]][x[1]] = 1;
            graph[x[1]][x[0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }

                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    continue;
                if (graph[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ranking t = new Ranking();
        System.out.println(t.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}