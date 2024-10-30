package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        long ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int rt = 0; rt < n; rt++) {
            hm.put(arr[rt], hm.getOrDefault(arr[rt], 0) + 1);
            while (hm.get(arr[rt]) > 1) {
                hm.put(arr[lt], hm.get(arr[lt]) - 1);
                if (hm.get(arr[lt]) == 0)
                    hm.remove(arr[lt]);
                lt++;
            }
            ans += (rt - lt + 1);
        }

        System.out.println(ans);
    }
}
