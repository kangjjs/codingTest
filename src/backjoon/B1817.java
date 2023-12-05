package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N==0){
            System.out.println(0);
            return;
        }

        int[] weight = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i]=Integer.parseInt(st.nextToken());
        }

        int ans=1;
        int w=0;
        for (int i = 0; i < N; i++) {
            w+=weight[i];
            if(M<w){
                ans++;
                w=weight[i];
            }
        }

        System.out.println(ans);
    }
}
