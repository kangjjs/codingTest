package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int lt = 0, rt = str2.length();
        int cnt = 0;
        while (rt <= str1.length()) {
            String s = str1.substring(lt, rt);
            if (s.equals(str2)) {
                lt += str2.length();
                rt += str2.length();
                cnt++;
            } else {
                lt += 1;
                rt += 1;
            }
        }

        System.out.println(cnt);
    }
}
