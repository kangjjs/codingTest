package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] need = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[] arr = new int[p];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < p; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            if(p<l)
                need[i] = 1;
            else{
                need[i] = arr[p-l];
            }
        }

        Arrays.sort(need);
        int ans =0;

        for(int x:need){
            if(x<=m){
                ans++;
                m-=x;
            }else
                break;
        }

        System.out.println(ans);
    }
}
