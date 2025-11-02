package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16198 {

    static int N, ans = 0;
    static int[] arr;
    static boolean[] remove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        remove = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        System.out.println(ans);
    }

    static void dfs(int l,int cur) {
        if (l == N - 2) {
            ans = Math.max(cur,ans);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            if(remove[i])
                continue;
            int left = i-1;
            while(left>=0 && remove[left])
                left--;
            int right = i+1;
            while(right<N && remove[right])
                right++;
            if(left>=0 && right <N){
                remove[i]=true;
                int gain = arr[left] * arr[right];
                dfs(l+1,cur+gain);
                remove[i]=false;
            }
        }
    }
}
