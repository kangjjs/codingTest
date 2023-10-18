package section10;

import java.util.*;

class S01 {

    public int solution(int n,int [] arr) {
        for(int i=3;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }

        return arr[n];
    }


    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int [] arr = new int[n+1];
        arr[1]=1;
        arr[2]=2;
        System.out.print(T.solution(n,arr));
    }
}
