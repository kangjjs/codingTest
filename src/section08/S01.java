package section08;

import java.util.*;
class S01 {
    static String answer="NO";
    static int n, total=0;
    boolean flag=false;

    static int [] arr;

    public void solution(int L, int sum){
        if(flag) return;
        if(sum>total/2) return;
        if(L==n){
            if((total-sum)==sum){
                answer="YES";
                flag=true;
            }
        }
        else{
            solution(L+1, sum+arr[L]);
            solution(L+1, sum);
        }
    }

    public static void main(String[] args){
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
            total+=arr[i];
        }
        T.solution(0, 0);
        System.out.print(answer);
    }
}