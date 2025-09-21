package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }

        int max = 0;
        String ans = "";

        for (String key : hm.keySet()) {
            int cnt = hm.get(key);
            if (cnt > max) {
                max = cnt;
                ans = key;
            } else if (cnt == max) {
                if (key.compareTo(ans) < 0) {
                    ans = key;
                }
            }
        }

        System.out.println(ans);
    }
}
