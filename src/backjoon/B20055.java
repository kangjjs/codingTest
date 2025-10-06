package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20055 {

    static int n, k;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[2 * n];
        robot = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        while (true) {
            ans++;

            rotate();
            move();
            putRobot();
            if(countZero()>=k)
                break;
        }

        System.out.println(ans);
    }

    static void rotate() {
        int last = belt[n * 2 - 1];

        for (int i = n * 2 - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }

        belt[0] = last;

        for (int i = n - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }

        robot[0] = false;
        robot[n - 1] = false;
    }

    static void move() {
        for (int i = n - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                belt[i + 1]--;
            }
        }

        robot[n-1]=false;
    }

    static void putRobot() {
        if (!robot[0] && belt[0] > 0) {
            robot[0] = true;
            belt[0]--;
        }
    }

    static int countZero() {
        int cnt = 0;
        for (int x : belt) {
            if (x == 0) cnt++;
        }
        return cnt;
    }
}
