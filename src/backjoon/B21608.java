package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B21608 {

    static int n;
    static HashMap<Integer, int[]> hm;
    static int[][] board;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        hm = new HashMap<>();
        board = new int[n + 1][n + 1];
        graph = new ArrayList<>();
        visited = new boolean[n + 1][n + 1];

        for (int i = 0; i <= n * n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                graph.get(num).add(Integer.parseInt(st.nextToken()));
            }

            find(num);
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum += cnt(i, j);
            }
        }

        System.out.print(sum);
    }

    static void find(int num) {
        int bestX = -1, bestY = -1;
        int emptyMax = -1, friendsMax = -1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j]) {
                    int friendCnt = 0;
                    int emptyCnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 1 || nx > n || ny < 1 || ny > n)
                            continue;
                        if (visited[nx][ny]) {
                            if (graph.get(num).contains(board[nx][ny]))
                                friendCnt++;
                        } else {
                            emptyCnt++;
                        }
                    }


                    if (friendsMax < friendCnt || (friendsMax == friendCnt && emptyMax < emptyCnt)
                            || (friendsMax == friendCnt && emptyMax == emptyCnt
                            && (i < bestX || (i == bestX) && (j < bestY)))) {
                        bestX = i;
                        bestY = j;
                        friendsMax = friendCnt;
                        emptyMax = emptyCnt;
                    }
                }
            }
        }

        board[bestX][bestY] = num;
        hm.put(num, new int[]{bestX, bestY});
        visited[bestX][bestY] = true;
    }

    static int cnt(int x, int y) {
        int val = board[x][y];
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || nx > n || ny < 1 || ny > n)
                continue;
            if (graph.get(val).contains(board[nx][ny]))
                cnt++;
        }

        switch (cnt) {
            case 1:
                return 1;
            case 2:
                return 10;
            case 3:
                return 100;
            case 4:
                return 1000;
            default:
                return 0;
        }
    }
}
