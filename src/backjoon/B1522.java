package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'a')
                count++;
        }
        int cnt = 0;
        for (int i = 0; i < count; i++) {
            if (str.charAt(i) == 'a')
                cnt++;
        }
        int ans = count - cnt;
        int lt=0,rt = count-1;

        while(lt<n){
            if(str.charAt(++rt%str.length())=='a')
                cnt++;
            if(str.charAt(lt++)=='a')
                cnt--;
            ans = Math.min(ans,count-cnt);
        }

        System.out.println(ans);
    }
}
