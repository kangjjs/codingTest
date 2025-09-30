package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int size = 1;
        while (size < n) {
            size *= 2;
        }

        int cnt = 0;
        int remain = n;
        int cur = size;

        while(remain >0){
            if(cur<=remain)
                remain -= cur;
            else{
                cur /=2;
                cnt++;
            }
        }

        System.out.println(size+" "+cnt);
    }
}
