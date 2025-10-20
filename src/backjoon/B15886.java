package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            if(str.charAt(i)=='E' && str.charAt(i+1)=='W')
                ans++;
        }

        System.out.println(ans);
    }
}
