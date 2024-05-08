package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int idx = 0;
        int ans = 0;
        while(true){
            ans++;
            String num = Integer.toString(ans);
            for (int i = 0; i < num.length(); i++) {
                if(num.charAt(i) == str.charAt(idx))
                    idx++;
                if(idx==str.length()){
                    System.out.println(ans);
                    return;
                }
            }
        }
    }
}
