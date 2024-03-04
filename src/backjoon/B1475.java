package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        int[] num = new int[10];

        for (char c : ch) {
            int x = c - '0';
            if (x == 9)
                num[6]++;
            else
                num[x]++;
        }

        if (num[6] % 2 == 0)
            num[6] = num[6] / 2;
        else
            num[6] = (num[6] / 2) + 1;
        System.out.println(Arrays.stream(num).max().getAsInt());
    }
}
