package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1987 {

    static int n, m, answer = Integer.MIN_VALUE;
    static int [][] board;
    static boolean[] visit = new boolean[26];

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};


    public void solution(int l, int x, int y) {
        if (visit[board[x][y]]) {
            answer = Math.max(answer,l);
            return;
        } else {
            visit[board[x][y]]=true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    solution(l + 1, nx, ny);
                }
            }
            visit[board[x][y]]=false;
        }

    }


    public static void main(String[] args) throws IOException {
        B1987 T = new B1987();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j)-'A';
            }
        }

        T.solution(0, 0, 0);

        System.out.print(answer);
    }
}
