package section08;

import java.util.Scanner;

public class S06 {

    static int n, m;
    static int[] arr1, check, arr2;

    public void solution(int k) {
        if (k == m) {
            for (int x : arr2)
                System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if(check[i]==0){
                    check[i]=1;
                    arr2[k]=arr1[i];
                    solution(k+1);
                    check[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        S06 T = new S06();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();

        arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }

        check = new int[n];
        arr2 = new int[m];

        T.solution(0);
    }
}
