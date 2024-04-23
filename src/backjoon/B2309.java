package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] fake = new int[9];

        for (int i = 0; i < 9; i++) {
            fake[i] = sc.nextInt();
        }

        int sum = Arrays.stream(fake).sum();
        int x = sum - 100;
        int a=0, b=0;
        Arrays.sort(fake);
        for (int i = 0; i < 8; i++) {
            for (int j = i+1 ; j < 9; j++) {
                if (fake[i] + fake[j] == x) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if(i==a || i== b)
                continue;
            System.out.println(fake[i]);
        }
    }
}
