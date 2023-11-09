package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14890 {

    static int n, l, ans = 0;

    public void solution(int[][] arr) {
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            int cnt = 1;

            for (int j = 0; j < n - 1; j++) {
                int cur = arr[i][j];
                int next = arr[i][j + 1];
                int diff = Math.abs(next - cur);

                if (diff == 0) {
                    cnt++;
                } else if (diff == 1) {
                    if (next > cur) {
                        if (cnt >= l) {
                            cnt = 1;
                        } else {
                            flag = false;
                            break;
                        }
                    } else {
                        for (int k = 1; k <= l; k++) {
                            if (next != arr[i][j + k]) {
                                flag = false;
                                break;
                            }
                        }

                        j += l - 1;
                        cnt = 0;
                    }
                } else if (diff >= 2) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        B14890 T = new B14890();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        int[][] board = new int[101][101];
        int[][] reverseBoard = new int[101][101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                reverseBoard[j][i] = board[i][j];
            }
        }

        T.solution(board);
        T.solution(reverseBoard);
        System.out.println(ans);
    }
}
