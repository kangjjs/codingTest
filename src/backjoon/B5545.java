package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B5545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        ArrayList<Integer> calories = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            calories.add(Integer.parseInt(br.readLine()));
        }

        calories.sort(Collections.reverseOrder());

        long sum = c;
        long price = a;
        long ans = sum / price;

        for (int i = 0; i < n; i++) {
            sum += calories.get(i);
            price += b;

            ans = Math.max(ans, sum / price);
        }

        System.out.println(ans);
    }
}
