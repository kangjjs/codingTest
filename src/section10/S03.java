package section10;

import java.util.Scanner;

public class S03 {

    static int[] arr;
    static int[] dy;

    public int solution(int n) {
        int answer = 0;
        dy = new int[n];
        dy[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;

            for (int j = i - 1; j > 0; j--) {
                if (arr[j] < arr[i] && max < dy[j] && dy[j] > max)
                    max = dy[j];
            }

            dy[i] = max + 1;

            answer = Math.max(dy[i],answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n));
    }
}