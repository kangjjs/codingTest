package ch01;

class Ch03 {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] board) {
        int answer = 0;
        int dp = 0, dd = 0, n = board.length, px = 0, py = 0, dogX = 0, dogY = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    px = i;
                    py = j;
                }
                if (board[i][j] == 3) {
                    dogX = i;
                    dogY = j;
                }
            }
        }

        while (answer < 10000) {
            answer++;
            int nx = px + dx[dp];
            int ny = py + dy[dp];
            int ddx = dogX + dx[dd];
            int ddy = dogY + dy[dd];
            boolean flag1 = true, flag2 = true;

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                dp = (dp + 1) % 4;
                flag1 = false;
            }

            if (ddx < 0 || ddx >= n || ddy < 0 || ddy >= n || board[ddx][ddy] == 1) {
                dd = (dd + 1) % 4;
                flag2 = false;
            }

            if (flag1) {
                px = nx;
                py = ny;
            }

            if (flag2) {
                dogX = ddx;
                dogY = ddy;
            }

            if (px==dogX && py==dogY)
                break;
        }

        if (answer >= 10000)
            return 0;
        else
            return answer;
    }

    public static void main(String[] args) {
        Ch03 T = new Ch03();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
