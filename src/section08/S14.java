package section08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S14 {

    static int n, answer = 0;
    static int[][] board;

    int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    int[] dy = {1, 0, -1, 1, -1, -1, 0, 1};
    static Queue<Point> queue = new LinkedList<>();

    public void bfs(int x, int y) {
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    public void solution() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    answer++;
                    board[i][j]=0;
                    bfs(i,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        S14 T = new S14();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        T.solution();
        System.out.print(answer);
    }
}
