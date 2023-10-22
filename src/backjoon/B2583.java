package backjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2583 {

    static int n, m, k, answer = 0,count=1;
    static int[][] board;
    static ArrayList<Integer> arrayList =new ArrayList<>();

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0&&nx<n&&ny>=0&&ny<m&&board[nx][ny]==0){
                board[nx][ny]=1;
                count++;
                dfs(nx,ny);
            }
        }
    }

    public void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    answer++;
                    board[i][j]=1;
                    dfs(i, j);
                    arrayList.add(count);
                    count=1;
                }
            }
        }
    }


    public static void main(String[] args) {
        B2583 T = new B2583();
        Scanner kb = new Scanner(System.in);

        m = kb.nextInt();
        n = kb.nextInt();
        k = kb.nextInt();

        board = new int[n][m];

        for (int i = 0; i < k; i++) {
            int x1 = kb.nextInt();
            int y1 = kb.nextInt();
            int x2 = kb.nextInt();
            int y2 = kb.nextInt();

            for (int j = x1; j < x2; j++) {
                for (int l = y1; l < y2; l++) {
                    board[j][l] = 1;
                }
            }
        }

        T.solution();
        Collections.sort(arrayList);

        System.out.println(answer);
        for(int x : arrayList){
            System.out.print(x+" ");
        }
    }
}
