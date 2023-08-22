package section10;

import java.util.Scanner;

public class S01 {

    static int [] dy;

    public int solution(int n){
        dy[1]=1;
        dy[2]=2;
        for(int i=3;i<=n;i++)
            dy[i]=dy[i-1]+dy[i-2];
        return dy[n];
    }

    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        dy=new int[n+1];

        System.out.println(T.solution(n));
    }
}
