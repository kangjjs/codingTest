package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B13413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();

        while(T-->0){
            int N =Integer.parseInt(br.readLine());

            String str1=br.readLine();
            String str2=br.readLine();

            int wCnt=0,bCnt=0;

            for (int i = 0; i < N; i++) {
                if(str1.charAt(i)!=str2.charAt(i)){
                    if(str1.charAt(i)=='B')
                        bCnt++;
                    else
                        wCnt++;
                }
            }

            if(bCnt>=wCnt)
                sb.append(bCnt);
            else
                sb.append(wCnt);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
