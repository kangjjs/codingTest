package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueen {
    static int ans,n;
    static int[] arr;

    static void dfs(int s){
        if(s==n){
            ans+=1;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[s] = i;
            if(check(s))
                dfs(s+1);
        }
    }

    static boolean check(int x){
        for (int i = 0; i < x; i++) {
            if(arr[i]==arr[x])
                return false;
            if(Math.abs(i-x) == Math.abs(arr[i]-arr[x]))
                return false;
        }

        return true;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            n = Integer.parseInt(br.readLine());
            ans = 0;
            arr = new int[n];
            dfs(0);
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
