package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PartialSum {
    static int n, m, ans;
    static int[] arr;

    static void dfs(int l,int s){
        if(l==n){
            if(s==m)
                ans++;
        }else{
            dfs(l+1,s+arr[l]);
            dfs(l+1,s);
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            ans = 0;
            dfs(0,0);
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
