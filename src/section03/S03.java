package section03;

import java.util.*;
class S03 {

    public int solution(int n,int m,int [] arr){

        int sum=0;

        for(int i=0;i<m;i++){
            sum+=arr[i];
        }

        int answer=sum;

        for(int i=m;i<n;i++){
            sum=sum+arr[i]-arr[i-m];
            answer=Math.max(sum,answer);
        }

        return answer;
    }

    public static void main(String[] args){
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int m= kb.nextInt();
        int [] arr =new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }

        System.out.print(T.solution(n,m,arr));
    }
}

