package section10;

import java.util.Scanner;

public class S02 {
    public int solution(int n, int[] arr) {
        for (int i = 3; i <= n+1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n+1];
    }


    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n + 2];
        arr[1] = 1;
        arr[2] = 2;
        System.out.print(T.solution(n, arr));
    }
}
