package section01;

import java.util.Scanner;

public class S04 {

    public void solution(String[] str) {
        int n = str.length;
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = "";
            for (int j = str[i].length() - 1; j >= 0; j--) {
                answer[i] += str[i].charAt(j);
            }
        }

        for (String s : answer) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = kb.next();
        }

        T.solution(str);
    }
}
