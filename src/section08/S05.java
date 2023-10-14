package section08;

import java.util.*;

class S05 {
    static int n,m;
    static int answer=Integer.MAX_VALUE;

    public void solution(int l,int sum,Integer [] arr) {
        if(sum>m)
            return;
        if(l>=answer)
            return;
        if(sum==m){
            answer=Math.min(answer,l);
        }else{
            for(int i=0;i<n;i++){
                solution(l+1,sum+arr[i],arr);
            }
        }
    }

    public static void main(String[] args) {
        S05 T = new S05();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        Integer [] arr = new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }
        Arrays.sort(arr,Collections.reverseOrder());

        m = kb.nextInt();

        T.solution(0,0,arr);
        System.out.print(answer);
    }
}