package section08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class S12 {

    static int n, m;

    static int[][] board,dis;
    static Queue<Point> queue = new LinkedList<>();
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void solution() {

        while(!queue.isEmpty()){
            Point p =queue.poll();

            for(int i=0;i<4;i++){
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];

                if(nx>=1&&nx<=n&&ny>=1&&ny<=m&&board[nx][ny]==0){
                    board[nx][ny]=1;
                    queue.offer(new Point(nx,ny));
                    dis[nx][ny]=dis[p.x][p.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        S12 T = new S12();
        Scanner kb = new Scanner(System.in);

        int answer=Integer.MIN_VALUE;
        m = kb.nextInt();
        n = kb.nextInt();
        boolean f=true;
        board = new int[n+1][m+1];
        dis = new int[n+1][m+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= m; j++) {
                board[i][j] = kb.nextInt();
                if(board[i][j]==1) {
                    queue.offer(new Point(i, j));
                }if(board[i][j]!=1)
                    f=false;
            }
        }

        if(f){
            System.out.print(0);
            return;
        }

        T.solution();

        boolean flag=true;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if (board[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }

        if(flag) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.print(answer);
        }else{
            System.out.print(-1);
        }
    }
}
