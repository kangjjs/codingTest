package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12782 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();
            int oneCnt=0,zeroCnt=0;

            for (int j = 0; j < a.length(); j++) {
                if(a.charAt(j)!=b.charAt(j)){
                    if(a.charAt(j)=='1')
                        oneCnt++;
                    else
                        zeroCnt++;
                }
            }

            if(oneCnt>=zeroCnt)
                sb.append(oneCnt);
            else
                sb.append(zeroCnt);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
