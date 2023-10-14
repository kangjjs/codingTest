package section07;

import java.util.*;

class S02 {

    public void solution(int n) {
        if(n<=1)
            System.out.print(1);
        else{
            solution(n/2);
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        T.solution(n);
    }
}
