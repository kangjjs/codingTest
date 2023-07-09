package section07;

import java.util.Scanner;

public class S01 {

    public void recursion(int n){
        if(n==0)
            return;
        else{
            recursion(n-1);
            System.out.print(n+" ");
        }
    }

    public void solution(int n){
        recursion(n);
    }

    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        T.solution(n);
    }
}
