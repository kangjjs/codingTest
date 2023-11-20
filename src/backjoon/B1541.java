package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("-");
        int ans = 0;

        for (int i = 0; i < str.length; i++) {
            int sum=0;

            String[] str2 =str[i].split("\\+");
            for (String s : str2) {
                sum += Integer.parseInt(s);
            }

            if(i==0)
                ans+=sum;
            else
                ans-=sum;
        }

        System.out.print(ans);
    }
}
