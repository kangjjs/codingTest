package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int rt;
        int[] sushi = new int[n];
        int[] ate = new int[d+1];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int cnt =0;
        for (int i = 0; i < k; i++) {
            if(ate[sushi[i]]==0)
                cnt++;
            ate[sushi[i]]++;
        }
        int ans =0;
        for (int i = 0; i < n; i++) {
            if(ans<=cnt){
                if(ate[c]==0)
                    ans = cnt+1;
                else
                    ans= cnt;
            }
            rt = (i+k) % n;
            if(ate[sushi[rt]]==0)
                cnt++;
            ate[sushi[rt]]++;
            ate[sushi[i]]--;
            if(ate[sushi[i]]==0)
                cnt--;
        }

        System.out.println(ans);
    }
}
