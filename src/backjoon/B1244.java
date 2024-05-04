package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 {

    static int[] arr;
    static int n;

    static void turn(int x) {
        if (arr[x] == 0)
            arr[x] = 1;
        else
            arr[x] = 0;
    }

    static void womanTurn(int x) {
        int lt = x;
        int rt = x;

        while (lt > 1 && rt < n) {
            int left = lt - 1;
            int right = rt + 1;

            if (arr[left] != arr[right]) {
                break;
            }

            lt = left;
            rt = right;
        }

        for (int i = lt; i <= rt; i++) {
            turn(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            if (num == 1) {
                int d = idx;
                while (idx <= n) {
                    turn(idx);
                    idx += d;
                }
            } else {
                womanTurn(idx);
            }
        }


        for (int i = 0; i < n; i++) {
            System.out.print(arr[i + 1] + " ");
            if ((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}
