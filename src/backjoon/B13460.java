package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13460 {

    static int n, m, srx, sry, sbx, sby;
    static char[][] board;
    static boolean[][][][] visited;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int rx, int ry, int bx, int by) {
        Queue<Points> q = new LinkedList<>();
        q.offer(new Points(rx, ry, bx, by));

        visited[rx][ry][bx][by] = true;
        int cnt = 1;

        while (!q.isEmpty() && cnt <= 10) {
            if (cnt == 11)
                return -1;
            for (int i = 0, size = q.size(); i < size; i++) {
                Points p = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nrx = p.rx;
                    int nry = p.ry;
                    int nbx = p.bx;
                    int nby = p.by;

                    boolean flagR = false;
                    boolean flagB = false;

                    int disR = 0, disB = 0;

                    while (true) {
                        nrx += dx[j];
                        nry += dy[j];

                        if (board[nrx][nry] == '#')
                            break;
                        if (board[nrx][nry] == 'O') {
                            flagR = true;
                            break;
                        }

                        disR++;
                    }

                    nrx -= dx[j];
                    nry -= dy[j];

                    while (true) {
                        nbx += dx[j];
                        nby += dy[j];

                        if (board[nbx][nby] == '#')
                            break;
                        if (board[nbx][nby] == 'O') {
                            flagB = true;
                            break;
                        }

                        disB++;
                    }

                    nbx -= dx[j];
                    nby -= dy[j];

                    if (nrx == nbx && nry == nby) {
                        if (disR > disB) {
                            nrx -= dx[j];
                            nry -= dy[j];
                        } else {
                            nbx -= dx[j];
                            nby -= dy[j];
                        }
                    }

                    if (flagR) {
                        if (!flagB) {
                            return cnt;
                        }
                    } else {
                        if (!visited[nrx][nry][nbx][nby] && !flagB) {
                            visited[nrx][nry][nbx][nby] = true;
                            q.offer(new Points(nrx, nry, nbx, nby));
                        }
                    }
                }
            }
            cnt++;
        }

        return -1;
    }


    public static void main(String[] args) throws IOException {
        B13460 T =new B13460();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m][n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);

                if (board[i][j] == 'B') {
                    sbx = i;
                    sby = j;
                }

                if (board[i][j] == 'R') {
                    srx = i;
                    sry = j;
                }

            }
        }

        System.out.println(T.solution(srx,sry,sbx,sby));
    }
}
