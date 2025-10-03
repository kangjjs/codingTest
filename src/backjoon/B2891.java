package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        boolean[] broke = new boolean[n + 1];
        boolean[] spare = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            broke[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (broke[num]) {
                broke[num] = false;
            } else {
                spare[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (broke[i]) {
                if (i > 1 && spare[i - 1]) {
                    spare[i - 1] = false;
                    broke[i] = false;
                }else if(i<n && spare[i+1]){
                    spare[i+1] = false;
                    broke[i] = false;
                }
            }
        }

        int ans =0;
        for(int i=1;i<=n;i++){
            if(broke[i])
                ans++;
        }

        System.out.println(ans);

    }
}
