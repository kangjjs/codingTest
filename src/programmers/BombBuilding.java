package programmers;

public class BombBuilding {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        int[][] sum = new int[row + 1][col + 1];

        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];

            if (type == 1)
                degree = -degree;
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] -= degree;
            sum[r2 + 1][c1] -= degree;
            sum[r2 + 1][c2 + 1] += degree;
        }

        for (int j = 0; j < col + 1; j++) {
            for (int i = 0; i < row; i++) {
                sum[i + 1][j] += sum[i][j];
            }
        }

        for (int i = 0; i < row + 1; i++) {
            for (int j = 0; j < col; j++) {
                sum[i][j + 1] += sum[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] + sum[i][j] > 0)
                    answer++;
            }
        }

        return answer;
    }
}
