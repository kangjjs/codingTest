package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        char[] ch = S.toCharArray();
        int zeroCnt = 0;
        int oneCnt = 0;

        if (ch[0] == '0') {
            zeroCnt++;
        } else {
            oneCnt++;
        }

        boolean flag = true;

        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == ch[i - 1])
                continue;
            if (ch[i] == '0') {
                flag = false;
                zeroCnt++;
            } else {
                flag = false;
                oneCnt++;
            }
        }

        if(flag){
            System.out.println(0);
            return;
        }

        int ans = Math.min(zeroCnt, oneCnt);

        System.out.println(ans);
    }
}
