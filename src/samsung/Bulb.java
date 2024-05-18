package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bulb {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(m<z){
                if(m<y){
                    sb.append(0).append('\n');
                }else{
                    if(y<n){
                        sb.append(m-n).append('\n');
                    }else{
                        sb.append(m-y).append('\n');
                    }
                }
            }else{
                if(z<n){
                    sb.append(0).append('\n');
                }else{
                    if(n<y){
                        sb.append(z-y).append('\n');
                    }else{
                        sb.append(z-n).append('\n');
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
