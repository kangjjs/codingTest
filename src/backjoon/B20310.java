package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int zeroCount = 0, oneCount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                zeroCount++;
            else
                oneCount++;
        }
        StringBuilder sb = new StringBuilder();
        int zero = 0, one = 0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='0'&&zero<zeroCount/2){
                zero++;
                sb.append("0");
            }

            if(str.charAt(i)=='1'){
                if(one<oneCount/2)
                    one++;
                else
                    sb.append("1");
            }
        }

        System.out.print(sb);
    }
}
