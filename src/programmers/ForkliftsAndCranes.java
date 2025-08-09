package programmers;

import java.util.*;

public class ForkliftsAndCranes {
    public int solution(String[] storage, String[] requests) {

        int n = storage.length;
        int m = storage[0].length();
        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = storage[i].toCharArray();
        }

        int remaining = n * m;

        for (String req : requests) {

            char target = req.charAt(0);

            if (req.length() == 2) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (map[i][j] == target) {
                            map[i][j] = '.';
                            remaining--;
                        }
                    }
                }
            } else {
                boolean[][] air = new boolean[n + 2][m + 2];
                Deque<int[]> q = new ArrayDeque<>();
                q.add(new int[]{0, 0});
                air[0][0] = true;

                int[] dx = {1, 0, -1, 0};
                int[] dy = {0, 1, 0, -1};

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || nx > n + 1 || ny < 0 || ny > m + 1) continue;
                        if (air[nx][ny]) continue;

                        boolean empty;
                        if (nx == 0 || nx == n + 1 || ny == 0 || ny == m + 1) {
                            empty = true;
                        } else {
                            empty = (map[nx - 1][ny - 1] == '.');
                        }

                        if (empty) {
                            air[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }

                List<int[]> toRemove = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (map[i][j] != target) continue;
                        int px = i + 1, py = j + 1; // 패딩 좌표
                        boolean accessible = false;
                        for (int d = 0; d < 4; d++) {
                            int nx = px + dx[d];
                            int ny = py + dy[d];
                            if (nx < 0 || nx > n + 1 || ny < 0 || ny > m + 1) continue;
                            if (air[nx][ny]) {
                                accessible = true;
                                break;
                            }
                        }
                        if (accessible) toRemove.add(new int[]{i, j});
                    }
                }

                for (int[] cell : toRemove) {
                    map[cell[0]][cell[1]] = '.';
                    remaining--;
                }
            }
        }

        return remaining;
    }
}