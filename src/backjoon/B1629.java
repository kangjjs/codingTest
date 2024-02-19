package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1629 {

    public static long pow(long x, long y, long z) {
        if (y == 1) {
            return x % z;
        }

        long temp = pow(x,y/2,z);
        if(y%2==1){
            return temp*temp%z*x%z;
        }

        return temp*temp%z;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long z = Long.parseLong(st.nextToken());

        System.out.println(pow(x,y,z));
    }
}
