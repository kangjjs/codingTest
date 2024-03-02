package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max = 0;
        int count = 1;

        for (int i = 0; i < N; i++) {
            sum+=arr[i];
            if(i==X-1)
                max=sum;
            if(i>X-1){
                sum -= arr[i-X];
                if(max<sum){
                    max=sum;
                    count=1;
                }else if(max==sum){
                    count++;
                }
            }
        }

        if(max==0)
            sb.append("SAD");
        else{
            sb.append(max).append("\n").append(count);
        }
        System.out.println(sb);
    }
}
