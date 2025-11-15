package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        ArrayList<Integer> lions = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1)
                lions.add(i);
        }

        if (lions.size() < k) {
            System.out.println(-1);
            return;
        }

        int lt = 0;
        int rt = k - 1;
        int ans = Integer.MAX_VALUE;
        while (rt < lions.size()) {
            ans = Math.min(ans, lions.get(rt) - lions.get(lt) + 1);
            lt++;
            rt++;
        }

        System.out.println(ans);
    }
}
