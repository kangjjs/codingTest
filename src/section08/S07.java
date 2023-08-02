package section08;

import java.util.Scanner;

public class S07 {

    public int solution(int c, int r) {
        if (c == r)
            return 1;
        else if (r == 1)
            return c;
        else
            return solution(c - 1, r - 1) + solution(c - 1, r);
    }

    public static void main(String[] args) {
        S07 T = new S07();
        Scanner kb = new Scanner(System.in);

        int c = kb.nextInt();
        int r = kb.nextInt();

        System.out.print(T.solution(c,r));
    }
}
