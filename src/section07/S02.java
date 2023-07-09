package section07;

import java.util.Scanner;

public class S02 {

    public void recursion(int n){
        if(n==1)
            System.out.print(1+" ");
        else{
            recursion(n/2);
            System.out.print(n%2+" ");
        }

    }

    public void solution(int n){
        recursion(n);
    }

    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        T.solution(n);
    }
}
