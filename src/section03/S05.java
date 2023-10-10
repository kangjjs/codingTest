package section03;

import java.util.*;
class S05 {

    public int solution(int n){
        int answer=0,lt=1,sum=0;

        int [] arr =new int[n/2+2];

        for(int i=1;i<=n/2+1;i++){
            arr[i]=i;
        }

        for(int rt=1;rt<arr.length;rt++){
            sum+=arr[rt];

            if(sum==n)
                answer++;

            while(sum>=n){
                sum-=arr[lt++];
                if(sum==n)
                    answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        S05 T = new S05();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();

        System.out.print(T.solution(n));
    }
}
