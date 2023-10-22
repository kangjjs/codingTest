package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class B2667Dfs {

    static int n, answer = 0, cnt = 1;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int[][] board;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                cnt++;
                board[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }

    public void solution() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    dfs(i, j);
                    arrayList.add(cnt);
                    cnt = 1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        B2667Dfs T = new B2667Dfs();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                board[i][j] = str.charAt(j) - '0';
            }
        }

        T.solution();

        System.out.println(answer);
        Collections.sort(arrayList);
        for (int x : arrayList) {
            System.out.print(x + " ");
        }
    }
}
