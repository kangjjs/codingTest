package backjoon;

import java.util.Scanner;

public class B1267 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] times = new int[n];

        for(int i=0;i<n;i++){
            times[i] = sc.nextInt();
        }

        int Y = 0, M =0;

        for(int t : times){
            Y += (t/30)*10 + 10;
            M += (t/60)*15 + 15;
        }

        if(Y==M){
            System.out.println("Y M "+Y);
        }else if(Y>M){
            System.out.println("M "+M);
        }else if(M>Y){
            System.out.println("Y "+Y);
        }
    }
}
