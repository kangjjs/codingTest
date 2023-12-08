package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        st =new StringTokenizer(br.readLine());
        int[] arr =new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        boolean flag = false;
        int ans=0;
        int x=0;

        for (int i = 0; i < N; i++) {
            if(arr[i]==A && !flag){
                x=A;
                ans++;
                flag=true;
            }

            if(flag && x+D==arr[i]){
                x=x+D;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
