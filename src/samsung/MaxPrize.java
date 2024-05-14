package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPrize {
    static char[] money;
    static int ans;

    static void dfs(int s,int L, int m) {
        if (L == m) {
            int x = Integer.parseInt(String.valueOf(money));
            ans = Math.max(ans, x);
        } else {
            for (int i = s; i < money.length; i++) {
                for (int j = i + 1; j < money.length; j++) {
                    char tmp = money[i];
                    money[i] = money[j];
                    money[j] = tmp;
                    dfs(i,L + 1, m);
                    tmp = money[i];
                    money[i] = money[j];
                    money[j] = tmp;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int num = 1;
        while (t-- > 0) {
            sb.append("#").append(num++).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            int m = Integer.parseInt(st.nextToken());
            money = n.toCharArray();
            ans = Integer.MIN_VALUE;
            dfs(0,0, m);
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
