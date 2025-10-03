package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B16954 {

    static char[][] board;
    static int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {1, 0, -1, 1, 0, -1, 1, 0, -1};

    static class State {
        int x, y, t;

        public State(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        boolean b = start();
        System.out.println(b ?1 :0);
    }

    static boolean start() {
        Queue<State> q = new LinkedList<>();
        boolean[][][] visited = new boolean[8][8][9];
        q.add(new State(7, 0, 0));
        visited[7][0][0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int t = cur.t;

            if (hasWall(x, y, t))
                continue;
            if (x == 0 && y == 7)
                return true;
            if (t >= 8)
                return true;

            for (int i = 0; i < 9; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nt = Math.min(8, t + 1);

                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8)
                    continue;

                if(hasWall(nx,ny,t))
                    continue;
                if(hasWall(nx,ny,nt))
                    continue;
                if(!visited[nx][ny][nt]){
                    visited[nx][ny][nt] = true;
                    q.add(new State(nx,ny,nt));
                }
            }
        }

        return false;
    }

    static boolean hasWall(int x, int y, int t) {
        int nx = x - t;
        if (nx < 0)
            return false;
        return board[nx][y] == '#';
    }
}
