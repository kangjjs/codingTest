package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B21313 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        boolean odd = N % 2 == 1;

        if (odd) {
            for (int i = 0; i < (N/2)+1; i++) {
                if(i==(N/2))
                    sb.append("3");
                else
                    sb.append("1 2 ");
            }
        } else {
            for (int i = 0; i < N /2 ; i++) {
                sb.append("1 2 ");
            }
        }

        System.out.println(sb);
    }
}
