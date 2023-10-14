package section08;

import java.util.*;

class S04 {
    static int n, m;
    static int [] arr;

    public void solution(int l) {
        if(l==m){
            for(int x : arr)
                System.out.print(x+" ");
            System.out.println();
        }else{
            for(int i=1;i<=n;i++){
                arr[l]=i;
                solution(l+1);
            }
        }
    }


    public static void main(String[] args) {
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();
        arr =new int [m];
        T.solution(0);
    }
}
