package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        char[] ch = str.toCharArray();
        int blue = 0, red = 0;

        for (int i = 0; i < n; i++) {
            if(i==0){
                if (ch[i] == 'B')
                    blue++;
                else if (ch[i] == 'R')
                    red++;
            }else{
                if(ch[i-1]==ch[i])
                    continue;
                else{
                    if (ch[i] == 'B')
                        blue++;
                    else if (ch[i] == 'R')
                        red++;
                }
            }
        }

        int ans = 0;

        if (blue >= red) {
            ans = 1 + red;
        } else {
            ans = 1 + blue;
        }

        System.out.println(ans);
    }
}
