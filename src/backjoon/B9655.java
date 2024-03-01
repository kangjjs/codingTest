package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int turn = 0;

        while (N != 0) {
            if(N>=3)
                N-=3;
            else
                N-=1;
            turn++;
        }

        if(turn%2==1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
