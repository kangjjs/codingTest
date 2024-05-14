package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WonjaeMemory {
    static int ans, n;
    static char[] arr,it;

    static void change(int i) {
        for (int j = i + 1; j < n; j++) {
            if(it[j]=='0')
                it[j]='1';
            else
                it[j]='0';
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            arr = br.readLine().toCharArray();
            ans = 0;
            n = arr.length;

            it = new char[n];
            Arrays.fill(it, '0');

            for (int i = 0; i < n; i++) {
                if (arr[i] != it[i]) {
                    change(i);
                    ans++;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
