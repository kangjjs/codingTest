package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B9017 {

    static class Rank {
        int cnt, sum, four,five;

        public Rank(int cnt, int sum) {
            this.cnt = cnt;
            this.sum = sum;
            this.four = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            int[] arr = new int[m + 1];
            HashMap<Integer, Rank> hm = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i] = x;
                hm.putIfAbsent(x, new Rank(0, 0));
                hm.get(x).cnt++;
                if (hm.get(x).cnt == 5) {
                    hm.get(x).five = i;
                }
            }

            int score = 1;
            for (int i = 1; i <= m; i++) {
                if (hm.get(arr[i]).cnt == 6) {
                    if(hm.get(arr[i]).four<5) {
                        hm.get(arr[i]).sum += score;
                    }
                    if (hm.get(arr[i]).five == i) {
                        hm.get(arr[i]).five = score;
                    }
                    score++;
                    hm.get(arr[i]).four++;
                }
            }

            int ans = 0;
            int sum = Integer.MAX_VALUE;
            int five = Integer.MAX_VALUE;
            for (int x : hm.keySet()) {
                if (hm.get(x).cnt == 6) {
                    if (sum == hm.get(x).sum) {
                        if (five > hm.get(x).five) {
                            ans = x;
                            sum = hm.get(x).sum;
                            five = hm.get(x).five;
                        }
                    } else if (sum > hm.get(x).sum) {
                        ans = x;
                        sum = hm.get(x).sum;
                        five = hm.get(x).five;
                    }
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}