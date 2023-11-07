package groom;

import java.io.*;
import java.util.Stack;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class BlockGame {

    static int n;
    static int[] s, answer;
    static char[] d;
    static boolean[][] visited;
    static Stack<Point> st = new Stack<>();
    static Stack<Integer> sn = new Stack<>();
    static boolean flag = false;

    static void solution(int l, int x, int y) {
        if (l == n) {
            System.out.println(answer[l]);
        } else {
            char ch = d[l];
            int nx = x, ny = y;
            switch (ch) {
                case 'R':
                    nx += 1;
                    break;
                case 'L':
                    nx -= 1;
                    break;
                case 'U':
                    ny += 1;
                    break;
                case 'D':
                    ny -= 1;
                    break;
            }

            if (nx >= 0 && nx < 2002 && ny >= 0 && ny < 2002) {
                if (!visited[nx][ny]) {
                    if (!flag) {
                        flag = true;
                        visited[1001][1001] = true;
                    }
                    answer[l + 1] = answer[l] + s[l+1];
                    visited[nx][ny] = true;
                    st.push(new Point(nx, ny));
                    sn.push(l+1);
                } else {
                    while (true) {
                        Point p = st.pop();
                        Integer i =sn.pop();
                        visited[p.x][p.y] = false;
                        answer[l] = answer[l] - s[i];
                        if (p.x == nx && p.y == ny) {
                            visited[nx][ny] = true;
                            answer[l + 1] = answer[l] + s[l+1];
                            sn.push(l+1);
                            st.push(new Point(nx, ny));
                            break;
                        }
                    }
                }
            }

            solution(l + 1, nx, ny);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        d = new char[n];
        s = new int[n+1];
        visited = new boolean[2002][2002];
        answer = new int[n + 1];
        answer[0] = 1;
        s[0]=1;
        st.push(new Point(1001, 1001));
        sn.push(0);

        String str = br.readLine();
        d = str.toCharArray();

        String[] num = br.readLine().split(" ");
        for (int i = 1; i <=n; i++) {
            s[i] = Integer.parseInt(num[i-1]);
        }

        solution(0, 1001, 1001);
    }
}