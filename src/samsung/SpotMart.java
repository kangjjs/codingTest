package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SpotMart {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int lt = 0;
            int rt = n - 1;
            int ans = -1;

            while (lt < rt) {
                int sum = arr[lt]+arr[rt];
                if(sum>m){
                    rt--;
                }else{
                    lt++;
                    ans = Math.max(ans,sum);
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
