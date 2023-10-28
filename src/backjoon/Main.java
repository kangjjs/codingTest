package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Building {
    public int x, y, z;

    public Building(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    static int l, r, c;
    static char[][][] building;
    static int[][][] answer;
    static boolean[][][] check;
    static Queue<Building> queue = new LinkedList<>();

    int[] dx = {1, -1, 0, 0, 0, 0};
    int[] dy = {0, 0, 1, -1, 0, 0};
    int[] dz = {0, 0, 0, 0, 1, -1};

    public void solution() {

        while (!queue.isEmpty()) {
            Building b = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = b.x + dx[i];
                int ny = b.y + dy[i];
                int nz = b.z + dz[i];

                if (nx >= 0 && nx < l && ny >= 0 && ny < r && nz >= 0 && nz < c && building[nx][ny][nz] != '#' && !check[nx][ny][nz]) {
                    queue.offer(new Building(nx, ny, nz));
                    check[nx][ny][nz] = true;
                    answer[nx][ny][nz] = answer[b.x][b.y][b.z] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0)
                break;

            building = new char[l][r][c];
            answer = new int[l][r][c];
            check = new boolean[l][r][c];

            int ax = 0, ay = 0, az = 0;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < c; k++) {
                        building[i][j][k] = str.charAt(k);
                        if (building[i][j][k] == 'S') {
                            queue.offer(new Building(i, j, k));
                        }

                        if (building[i][j][k] == 'E') {
                            ax = i;
                            ay = j;
                            az = k;
                        }
                    }
                }
                br.readLine();
            }

            T.solution();

            if (check[ax][ay][az]) {
                System.out.println("Escaped in " + answer[ax][ay][az] + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }
}