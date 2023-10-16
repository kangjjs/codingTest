package section08;

import java.util.*;
class Main {

    int [][] dy = new int[35][35];

    public int solution(int n,int r) {
        if(dy[n][r]>0)
            return dy[n][r];
        if(n==r||r==0)
            return 1;
        else
            return dy[n][r]=solution(n-1,r-1)+solution(n-1,r);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int r = kb.nextInt();
        System.out.print(T.solution(n,r));
    }
}