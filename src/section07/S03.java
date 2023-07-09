package section07;

import java.util.Scanner;

public class S03 {

    public int solution(int n){
        if(n==1)
            return 1;
        else
            return n*solution(n-1);
    }

    public static void main(String[] args) {
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.print(T.solution(n));
    }
}
