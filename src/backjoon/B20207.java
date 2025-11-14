package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] days = new int[366];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                days[j]++;
            }
        }

        int ans = 0;
        int width = 0;
        int height = 0;
        for (int i = 1; i <= 365; i++) {
            if (days[i] > 0) {
                height = Math.max(height,days[i]);
                width++;
            }else{
                ans += (height*width);
                height=0;
                width=0;
            }
        }

        System.out.println(ans);
    }
}
