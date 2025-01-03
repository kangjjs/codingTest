package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10819 {

    static int k, ans;
    static int[] arr, selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new int[k];
        ans = 0;
        selected = new int[k];
        visited = new boolean[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(ans);
    }

    static void dfs(int l) {
        if (l == k) {
            int sum = 0;
            for (int i = 0; i < k - 1; i++) {
                sum += Math.abs(arr[i] - arr[i + 1]);
            }
            ans = Math.max(ans, sum);
        } else {
            for (int i = l; i < k; i++) {
                swap(l, i);
                dfs(l + 1);
                swap(i, l);
            }
        }
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
