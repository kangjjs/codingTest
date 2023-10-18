package section10;

import java.util.Scanner;

public class S03 {
    public int solution(int n, int[] arr) {

        int answer = Integer.MIN_VALUE;
        int[] dy = new int[n];
        dy[0] = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && max<dy[j]){
                    max = dy[j];
                }
            }

            dy[i] = max+1;
            answer = Math.max(dy[i],answer);
        }

        return answer;
    }


    public static void main(String[] args) {
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(n, arr));
    }
}
