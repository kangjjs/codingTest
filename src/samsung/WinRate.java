package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WinRate {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            double n = Integer.parseInt(st.nextToken());
            double m = Integer.parseInt(st.nextToken());
            double y = Integer.parseInt(st.nextToken());
            double z = Integer.parseInt(st.nextToken());

            double alice = n/m;
            double bob = y/z;

            if(alice>bob){
                sb.append("ALICE").append('\n');
            }else if(alice==bob){
                sb.append("DRAW").append('\n');
            }else{
                sb.append("BOB").append('\n');
            }
        }
        System.out.print(sb);
    }
}
