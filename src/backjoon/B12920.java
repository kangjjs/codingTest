package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B12920 {

    static class Thing {
        int w, v;

        public Thing(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Thing> things = new ArrayList<>();
        things.add(new Thing(0,0));
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            int tmp = 1;
            while (tmp <= z) {
                things.add(new Thing(x * tmp, y * tmp));
                z -= tmp;
                tmp *= 2;
            }

            if (z != 0)
                things.add(new Thing(z * x, z * y));
        }

        int[][] dp = new int[things.size()+1][m + 1];
        for (int i = 1; i < things.size(); i++) {
            for (int j = 1; j <=m; j++) {
                dp[i][j] = dp[i-1][j];
                if(j-things.get(i).w>=0){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-things.get(i).w]+things.get(i).v);
                }
            }
        }

        System.out.println(dp[things.size()-1][m]);
    }
}
