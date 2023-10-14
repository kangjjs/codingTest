package section08;

import java.util.*;

class S02 {

    static int[] arr;
    static int n, w;
    static int answer=0;

    public void solution(int l, int sum, int[] arr) {
        if(sum>w)
            return;
        if(l==n)
            answer=Math.max(sum,answer);
        else{
            solution(l+1,sum+arr[l],arr);
            solution(l+1,sum,arr);
        }
    }


    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);

        w = kb.nextInt();
        n = kb.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        T.solution(0,0,arr);
        System.out.print(answer);
    }
}
