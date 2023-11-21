package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        boolean flag = false;

        if(n==1||n==3){
            System.out.println(-1);
            return;
        }

        while (n != 0) {
            if (!flag && n >= 5) {
                n -= 5;
            } else if (flag || n < 5) {
                if (n % 2 == 1) {
                    n += 5;
                    cnt--;
                    flag = true;
                }
                n -= 2;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
