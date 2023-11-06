package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {

    int num, cnt;

    public Node(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node o) {
        if (this.cnt == o.cnt)
            return this.num - o.num;
        return this.cnt - o.cnt;
    }
}

public class B17140 {

    static int n, m, k, row, col;
    static int[][] board;

    public static void row_cal() {
        int[][] copyBoard = new int[101][101];
        int c = 0;

        for (int i = 0; i < row; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 0)
                    continue;
                hm.put(board[i][j], hm.getOrDefault(board[i][j], 0) + 1);
            }
            ArrayList<Node> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                list.add(new Node(entry.getKey(), entry.getValue()));
            }

            c = Math.max(c, list.size() * 2);
            Collections.sort(list);

            for (int j = 0; j < list.size(); j++) {
                if (j >= 50)
                    break;
                Node node = list.get(j);
                copyBoard[i][2 * j] = node.num;
                copyBoard[i][2 * j + 1] = node.cnt;
            }
        }

        col = Math.min(99, c);
        board = copyBoard;
    }

    public static void col_cal() {
        int[][] copyBoard = new int[101][101];
        int r = 0;

        for (int i = 0; i < col; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j = 0; j < row; j++) {
                if (board[j][i] == 0)
                    continue;
                hm.put(board[j][i], hm.getOrDefault(board[j][i], 0) + 1);
            }
            ArrayList<Node> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                list.add(new Node(entry.getKey(), entry.getValue()));
            }
            r = Math.max(r, list.size() * 2);
            Collections.sort(list);

            for (int j = 0; j < list.size(); j++) {
                if (j >= 50)
                    break;
                Node node = list.get(j);
                copyBoard[2 * j][i] = node.num;
                copyBoard[2 * j + 1][i] = node.cnt;
            }
        }

        row = Math.min(99, r);
        board = copyBoard;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[101][101];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        row = 3;
        col = 3;

        int ans = -1;
        int cnt = 0;

        while (cnt <= 100) {
            if (board[n - 1][m - 1] == k) {
                ans = cnt;
                break;
            }

            if (row >= col) {
                row_cal();
            } else {
                col_cal();
            }

            cnt++;
        }

        System.out.println(ans);
    }
}
