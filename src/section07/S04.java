package section07;

import java.util.*;

class S04 {

    public int solution(int n) {
        if(n==1)
            return 1;
        else if(n==2)
            return 1;
        else
            return solution(n-1)+solution(n-2);
    }

    public static void main(String[] args) {
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        for(int i=1;i<=n;i++){
            System.out.print(T.solution(i)+" ");
        }
    }
}
