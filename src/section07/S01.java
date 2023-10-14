package section07;

import java.util.*;

class S01 {

    public void solution(int n) {
        if(n<=1)
            System.out.print(1+" ");
        else{
            solution(n-1);
            System.out.print(n+" ");
        }
    }

    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        T.solution(n);
    }
}

