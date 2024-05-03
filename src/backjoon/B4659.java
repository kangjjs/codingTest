package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals("end"))
                break;
            boolean flagOne = false;
            boolean flagTwo = true;
            boolean flagThree = true;

            char[] c = s.toCharArray();
            int cnt1 = 0, cnt2 = 0;
            for (int i = 0; i < c.length; i++) {
                if (c[i] == 'a' || c[i] == 'e' || c[i] == 'o' || c[i] == 'i' || c[i] == 'u') {
                    flagOne = true;
                    cnt1++;
                    cnt2 = 0;
                    if (cnt1 >= 3) {
                        flagTwo = false;
                        break;
                    }
                } else {
                    cnt2++;
                    cnt1 = 0;
                    if (cnt2 >= 3) {
                        flagTwo = false;
                        break;
                    }
                }


                if (i != c.length-1) {
                    if(c[i]==c[i+1]){
                        flagThree = c[i]=='e'||c[i]=='o';
                    }
                }
            }

            if (flagOne && flagTwo && flagThree) {
                sb.append("<").append(s).append("> is acceptable.").append('\n');
            } else {
                sb.append("<").append(s).append("> is not acceptable.").append('\n');
            }
        }

        System.out.println(sb);
    }
}
