package programmers;

import java.util.Arrays;

public class DivideNumberCard {
    static boolean check1(int n, int[] array) {
        for (int j : array) {
            if (j % n != 0)
                return false;
        }

        return true;
    }

    static boolean check2(int n, int[] array) {
        for (int j : array) {
            if (j % n == 0)
                return false;
        }

        return true;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        for (int i = 2; i <= arrayA[0]; i++) {
            if (check1(i, arrayA)) {
                if (check2(i, arrayB)) {
                    answer = Math.max(answer, i);
                }
            }
        }

        for (int i = 2; i <= arrayB[0]; i++) {
            if (check1(i, arrayB)) {
                if (check2(i, arrayA)) {
                    answer = Math.max(answer, i);
                }
            }
        }

        return answer;
    }
}
