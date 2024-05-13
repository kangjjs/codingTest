package samsung;

import java.util.Scanner;

class Snail {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            int d = 0;
            int x = 0;
            int y = 0;

            for (int i = 1; i <= n*n ; i++) {
                map[x][y] = i;
                int nx = x+dx[d];
                int ny = y+dy[d];

                if(nx<0||nx>=n||ny<0||ny>=n||map[nx][ny]!=0){
                    d = (d+1) %4;
                    nx = x+dx[d];
                    ny = y+dy[d];
                }

                x = nx;
                y = ny;
            }


            System.out.println("#" + test_case);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}