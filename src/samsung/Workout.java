package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Workout {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken());
            long m = Integer.parseInt(st.nextToken());
            long k = Integer.parseInt(st.nextToken());
            if (n > k) {
                sb.append(n - k).append('\n');
            }else if(k<=m){
                sb.append("0").append('\n');
            }else{
                sb.append("-1").append('\n');
            }
        }
        System.out.print(sb);
    }
}
