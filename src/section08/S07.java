package section08;

import java.util.Scanner;

public class S07 {

    static int n,m,answer=0;

    public void solution(int k,int l){
        if(l==1) {
            answer += k;
            return;
        }
        if(k==l) {
            answer += 1;
            return;
        }
        else{
            solution(k-1,l-1);
            solution(k-1,l);
        }
    }

    public static void main(String[] args) {
        S07 T = new S07();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();

        T.solution(n,m);
        System.out.print(answer);
    }
}